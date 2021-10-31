package com.example.temadam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AntrenamentAdapter extends BaseAdapter {

    private List<Antrenament> listaAntrenamente=new ArrayList<>();

    public AntrenamentAdapter(List<Antrenament> listaAntrenamente) {
        this.listaAntrenamente = listaAntrenamente;
    }

    @Override
    public int getCount() {
        return listaAntrenamente.size();
    }

    @Override
    public Object getItem(int i) {
        return listaAntrenamente.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        View view1=inflater.inflate(R.layout.antrenament_menu, viewGroup, false);
        TextView textDenumire=view1.findViewById(R.id.tvDenumire);
        TextView textDurata=view1.findViewById(R.id.tvDurata);
        TextView textEchipament=view1.findViewById(R.id.tvEchipament);

        Antrenament temp=listaAntrenamente.get(pos);
        textDenumire.setText(temp.getDenumire());
        textDurata.setText(temp.getDurata().toString());
        textEchipament.setText(temp.getEchipament());

        return view1;
    }

    public void updateList(List<Antrenament> lista){
        //listaAntrenamente.clear();
        listaAntrenamente.addAll(lista);
        notifyDataSetChanged();
    }
}
