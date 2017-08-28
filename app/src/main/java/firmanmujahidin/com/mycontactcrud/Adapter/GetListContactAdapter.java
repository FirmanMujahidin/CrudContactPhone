package firmanmujahidin.com.mycontactcrud.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import firmanmujahidin.com.mycontactcrud.EditActivity;
import firmanmujahidin.com.mycontactcrud.Model.Contact;
import firmanmujahidin.com.mycontactcrud.R;

/**
 * Created by firma on 17-Aug-17.
 */

public class GetListContactAdapter extends RecyclerView.Adapter<GetListContactAdapter.MyViewHolder> {

    List<Contact> mResultList;
    private Context mContext;

    public GetListContactAdapter(List<Contact> mResultList, Context mContext) {
        this.mResultList = mResultList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.items_contact, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewId.setText("Id = " + mResultList.get(position).getId());
        holder.mTextViewNama.setText("Nama = " + mResultList.get(position).getNama());
        holder.mTextViewNomor.setText("Nomor = " + mResultList.get(position).getNomor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), EditActivity.class);
                mIntent.putExtra("Id", mResultList.get(position).getId());
                mIntent.putExtra("Nama", mResultList.get(position).getNama());
                mIntent.putExtra("Nomor", mResultList.get(position).getNomor());
                view.getContext().startActivity(mIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mResultList == null ? 0 : mResultList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextViewId, mTextViewNama, mTextViewNomor;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTextViewId = (TextView) itemView.findViewById(R.id.tvId);
            mTextViewNama = (TextView) itemView.findViewById(R.id.tvNama);
            mTextViewNomor = (TextView) itemView.findViewById(R.id.tvNomor);
        }
    }
}
