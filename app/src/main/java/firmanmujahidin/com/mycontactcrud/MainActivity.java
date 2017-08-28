package firmanmujahidin.com.mycontactcrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import firmanmujahidin.com.mycontactcrud.Adapter.GetListContactAdapter;
import firmanmujahidin.com.mycontactcrud.Model.Contact;
import firmanmujahidin.com.mycontactcrud.Model.GetContact;
import firmanmujahidin.com.mycontactcrud.Rest.ApiClient;
import firmanmujahidin.com.mycontactcrud.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    Button mBtIns;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    GetListContactAdapter mLayoutAdapter;

    public static MainActivity mMainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtIns = (Button) findViewById(R.id.mBtIns);
        mBtIns.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);

        mApiInterface = ApiClient.initRetrofit();
        mMainActivity = this;
        refresh();
    }


    void refresh(){
        final Call<GetContact> getContactCall = mApiInterface.getListContact();
        getContactCall.enqueue(new Callback<GetContact>() {
            @Override
            public void onResponse(Call<GetContact> call, Response<GetContact> response) {
                List<Contact> ContactList = response.body().getListDataContact();

                if (response.isSuccessful()){
                    mLayoutAdapter = new GetListContactAdapter(ContactList, getApplicationContext());
                    mLayoutManager = new LinearLayoutManager(getApplicationContext());
                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mRecyclerView.setAdapter(mLayoutAdapter);
                }
            }

            @Override
            public void onFailure(Call<GetContact> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
            }
        });
    }
}
