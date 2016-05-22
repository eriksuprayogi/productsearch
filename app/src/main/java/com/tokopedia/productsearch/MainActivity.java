package com.tokopedia.productsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.tokopedia.productsearch.adapter.EndlessRecyclerOnScrollListener;
import com.tokopedia.productsearch.adapter.ProductListAdapter;
import com.tokopedia.productsearch.model.ProductResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MaterialSearchView.OnQueryTextListener, Callback<ProductResponse> {

    @Bind(R.id.search_view)
    MaterialSearchView searchView;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.list)
    RecyclerView recyclerView;

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProductListAdapter listAdapter;
    private int rows = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        searchView.setOnQueryTextListener(this);
        setSupportActionBar(toolbar);
        listAdapter = new ProductListAdapter(this);
//        recyclerView.addItemDecoration(new MarginDecoration(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(listAdapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore(int currentPage) {
                Log.d(TAG, "onLoadMore " + currentPage);
                AppApplication.getEndpointInterface().getProduct(rows, (rows*currentPage)).enqueue(MainActivity.this);
            }
        });
        AppApplication.getEndpointInterface().getProduct(rows, 0).enqueue(this);
    }

    @Override
    public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
        Log.d(TAG, "onResponse "+response.body().getStatus());
        if(response.body().getStatus().equals("OK")) {
            listAdapter.addProducts(response.body().getResult().getProducts());
        }
    }

    @Override
    public void onFailure(Call<ProductResponse> call, Throwable t) {
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
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d(TAG, "onQueryTextChange "+newText);
        return false;
    }
}
