package co.edu.tiendpp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.edu.tiendpp.R;
import co.edu.tiendpp.administrador.creditos.menu.FormularioSolicitudActivity;


public class SolicitudCreditoAdapter extends BaseAdapter {


    private final LayoutInflater inflater;
    private Context context;

    private List<String[]> solicitudes;

    public SolicitudCreditoAdapter(Context context, List<String[]> solicitudes){
        inflater= LayoutInflater.from(context);
        this.context=context;
        this.solicitudes=solicitudes;
    }



    @Override
    public int getCount() {
        return solicitudes.size();
    }

    @Override
    public Object getItem(int position) {
        return solicitudes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String[] solicitud= (String[]) getItem(position);
        ViewHolder holder;
        if(convertView!=null){
            holder=(ViewHolder) convertView.getTag();
        }
        else{
            convertView=inflater.inflate(R.layout.item_solicitud_credito,parent,false);
            holder= new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.idCredito.setText(solicitudes.get(position)[0]);
        holder.solicitante.setText(solicitudes.get(position)[1]);
        holder.fecha.setText(solicitudes.get(position)[2]);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, FormularioSolicitudActivity.class);
                intent.putExtra("solicitud",solicitud);
                context.startActivity(intent);

            }
        });

        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.txtIdCredito)
        TextView idCredito;
        @BindView(R.id.txtSolicitante)
        TextView solicitante;
        @BindView(R.id.txtFecha)
        TextView fecha;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }


    }
}
