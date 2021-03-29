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
import co.edu.tiendpp.administrador.creditos.menu.AbonosActivity;

public class CreditoActivoAdapter extends BaseAdapter {

    private final LayoutInflater inflater;
    private Context context;

    private List<String[]> creditosActiivos;

    public CreditoActivoAdapter( Context context, List<String[]> creditosActivos) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.creditosActiivos = creditosActivos;
    }

    @Override
    public int getCount() {
        return creditosActiivos.size();
    }

    @Override
    public Object getItem(int position) {
        return creditosActiivos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String[] creditos=(String[]) getItem(position);
        ViewHolder holder;
        if (convertView!=null) {
            holder=(ViewHolder) convertView.getTag();
        }
        else{
            convertView=inflater.inflate(R.layout.item_creditos_activos,parent,false);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.idCredito.setText(creditosActiivos.get(position)[0]);
        holder.solicitante.setText(creditosActiivos.get(position)[1]);
        holder.telefono.setText(creditosActiivos.get(position)[2]);
        holder.valorDeuda.setText(creditosActiivos.get(position)[5]);
        holder.fechaAbono.setText(creditosActiivos.get(position)[6]);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, AbonosActivity.class);
                intent.putExtra("creditos",creditos);
                context.startActivity(intent);

            }
        });

        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.txtNumeroCredito)
        TextView idCredito;
        @BindView(R.id.txtNombreDeudor)
        TextView solicitante;
        @BindView(R.id.txtTelefonoDeudor)
        TextView telefono;
        @BindView(R.id.txtValorDeuda)
        TextView valorDeuda;
        @BindView(R.id.txtFechaUltimoAbono)
        TextView fechaAbono;

        public ViewHolder(View view){
            ButterKnife.bind(this,view);
        }


    }
}
