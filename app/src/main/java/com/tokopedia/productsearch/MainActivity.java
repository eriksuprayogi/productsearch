package com.tokopedia.productsearch;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.github.yasevich.endlessrecyclerview.EndlessRecyclerView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.tokopedia.productsearch.adapter.ProductListAdapter;
import com.tokopedia.productsearch.model.ProductResponse;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MaterialSearchView.OnQueryTextListener, Callback<ProductResponse>, EndlessRecyclerView.Pager {

    @Bind(R.id.search_view)
    MaterialSearchView searchView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.list)
    EndlessRecyclerView recyclerView;

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProductListAdapter listAdapter;
    private static final int ITEMS_ON_PAGE = 8;
    private static final int TOTAL_PAGES = 10;
    private String searchTerm = "";
    private Boolean newSearch = true;
    private boolean loading = false;
    private ProductResponse.Paging paging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        searchView.setOnQueryTextListener(this);
        setSupportActionBar(toolbar);
        listAdapter = new ProductListAdapter(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(listAdapter);
        recyclerView.setProgressView(R.layout.item_progress);
        recyclerView.setPager(this);
        AppApplication.getEndpointInterface().getProduct(String.valueOf(TOTAL_PAGES), "0", searchTerm).enqueue(this);
    }

    @Override
    public boolean shouldLoad() {
        return !loading && listAdapter.getItemCount() - ITEMS_ON_PAGE < listAdapter.getItemCount();
    }

    @Override
    public void loadNextPage() {
        loading = true;
        newSearch = false;
        if(paging == null)
            return;
        Uri uri = Uri.parse(paging.getUri_next());
        Log.d(TAG, "next_uri "+uri.toString());
        AppApplication.getEndpointInterface().getProduct(uri.getQueryParameter("rows"), uri.getQueryParameter("start"), uri.getQueryParameter("q")).enqueue(MainActivity.this);
    }

    @Override
    public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
        Log.d(TAG, "onResponse " + response.body().getStatus());
        loading = false;
        if (response.body().getStatus().equals("OK")) {
            paging = response.body().getResult().getPaging();
            recyclerView.setRefreshing(false);
            if (newSearch) {
                listAdapter.setProducts(response.body().getResult().getProducts());
            } else {
                listAdapter.addProducts(response.body().getResult().getProducts());
            }
        }
    }

    @Override
    public void onFailure(Call<ProductResponse> call, Throwable t) {
        loading = false;
        recyclerView.setRefreshing(false);
        Log.e(TAG, "onFailure");
        t.printStackTrace();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (query.isEmpty()) {
            searchTerm = "";
        } else {
            searchTerm = query;
        }
        newSearch = true;
        recyclerView.setRefreshing(true);
        AppApplication.getEndpointInterface().getProduct(String.valueOf(TOTAL_PAGES), "0", searchTerm).enqueue(this);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.isEmpty()) {
            searchTerm = "";
        } else {
            searchTerm = newText;
        }
        newSearch = true;
        recyclerView.setRefreshing(true);
        AppApplication.getEndpointInterface().getProduct(String.valueOf(TOTAL_PAGES), "0", searchTerm).enqueue(this);
        return false;
    }
}
