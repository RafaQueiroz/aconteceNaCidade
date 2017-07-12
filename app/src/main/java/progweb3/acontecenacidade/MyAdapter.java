package progweb3.acontecenacidade;

import android.content.Context;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import progweb3.acontecenacidade.Util.EventoUtil;

/**
 * Created by KOSMOS00 on 19/06/2017.
 */


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public static ClickRecycler clickRecycler;
    Context contexto;
    private List<Evento> listaEventos;

    public MyAdapter(Context ctx, List<Evento> list, ClickRecycler clickRecycler) {
        this.contexto = ctx;
        this.listaEventos = list;
        this.clickRecycler = clickRecycler;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        System.out.println("Contexto="+viewGroup.getContext());
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_events, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder,final int position) {

        Evento evento = listaEventos.get(position);

        viewHolder.viewNome.setText(evento.getNome());
        viewHolder.viewData.setText(EventoUtil.calendarToString(
                evento.getDtInicio().getTimeInMillis(), "dd/MM/yyyy"));

        //=====>AGORA MUDA
        int id = contexto.getResources().getIdentifier("drawable/even"+evento.getIdImagem(),
                "drawable", contexto.getPackageName());
        viewHolder.viewImag.setImageResource(id);

    }
    private void removeItem(int position) {
        listaEventos.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listaEventos.size());
    }
    @Override
    public int getItemCount() {
        return listaEventos != null ? listaEventos.size() : 0;

    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;
        protected TextView viewData;
        protected ImageView viewImag;
        protected ImageButton delete;

        public MyViewHolder(final View itemView) {
            super(itemView);
            viewNome = (TextView) itemView.findViewById(R.id.evento_list_nome);
            viewData = (TextView) itemView.findViewById(R.id.evento_list_data_inicio);
            viewImag = (ImageView) itemView.findViewById(R.id.evento_list_image);
            //delete = (ImageButton) itemView.findViewById(R.id.line_delete);

            //Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickRecycler.onCustomClick(listaEventos.get(getLayoutPosition()));
                }
            });
        }
    }
}

