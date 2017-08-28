package firmanmujahidin.com.mycontactcrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import firmanmujahidin.com.mycontactcrud.Model.PostPutDeletContact;
import firmanmujahidin.com.mycontactcrud.Rest.ApiClient;
import firmanmujahidin.com.mycontactcrud.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditActivity extends AppCompatActivity {

    private EditText mEtId, mEtUser, mEtNomor;
    private Button mButnUpdate, mButnDelet;
    public static MainActivity mMainActivity;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEtId = (EditText) findViewById(R.id.etId);
        mEtUser = (EditText) findViewById(R.id.etUser);
        mEtNomor = (EditText) findViewById(R.id.etNomor);

        //Mengambil data dari adapter
        Intent mIntent = getIntent();
        mEtId.setText(mIntent.getStringExtra("Id"));
        mEtId.setTag(mEtId.getKeyListener());
        mEtId.setKeyListener(null);

        mEtUser.setText(mIntent.getStringExtra("Nama"));
        mEtNomor.setText(mIntent.getStringExtra("Nomor"));

        mApiInterface = ApiClient.initRetrofit();

        mButnUpdate = (Button) findViewById(R.id.butnUpdate);
        mButnDelet = (Button) findViewById(R.id.butnDelet);

        mButnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDeletContact> updateKontakCall = mApiInterface.editContact(
                        mEtId.getText().toString(),
                        mEtUser.getText().toString(),
                        mEtNomor.getText().toString());
                updateKontakCall.enqueue(new Callback<PostPutDeletContact>() {
                    @Override
                    public void onResponse(Call<PostPutDeletContact> call, Response<PostPutDeletContact> response) {
                        MainActivity.mMainActivity.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDeletContact> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        mButnDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDeletContact> deletContactCall = mApiInterface.deletContact(mEtId.getText().toString());
                    deletContactCall.enqueue(new Callback<PostPutDeletContact>() {
                        @Override
                        public void onResponse(Call<PostPutDeletContact> call, Response<PostPutDeletContact> response) {
                            MainActivity.mMainActivity.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDeletContact> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
