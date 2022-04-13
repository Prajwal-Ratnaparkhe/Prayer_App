package com.msquare.prarthananjali;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.VersionVH> {
    List<Versions> versionsList;

    public VersionAdapter(List<Versions> versionsList) {
        this.versionsList = versionsList;
    }

    @NonNull
    @Override
    public VersionAdapter.VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new VersionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionAdapter.VersionVH holder, int position) {
        Versions versions=versionsList.get(position);
        holder.codeNameTxt.setText(versions.getCodeName());
        holder.versionTxt.setText(versions.getVersion());
        holder.apiLevelTxt.setText(versions.getApiLevel());
        holder.decriptionTxt.setText(versions.getDescription());

        boolean isExpandable=versionsList.get(position).isExpandable();
        holder.expandablelayout.setVisibility(isExpandable ? View.VISIBLE:View.GONE);

    }

    @Override
    public int getItemCount() {
        return versionsList.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder {
        TextView codeNameTxt,versionTxt,apiLevelTxt,decriptionTxt;
        LinearLayout linearLayout;
        RelativeLayout expandablelayout;
        public VersionVH(@NonNull View itemView) {
            super(itemView);
            codeNameTxt=itemView.findViewById(R.id.code_name);
            versionTxt=itemView.findViewById(R.id.version);
            apiLevelTxt=itemView.findViewById(R.id.api_level);
            decriptionTxt=itemView.findViewById(R.id.description);

            linearLayout=itemView.findViewById(R.id.linear_layout);
            expandablelayout=itemView.findViewById(R.id.expandable_layout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Versions versions=versionsList.get(getBindingAdapterPosition());
                    versions.setExpandable(!versions.isExpandable());
                    notifyItemChanged(getBindingAdapterPosition());
                }
            });

        }
    }
}
