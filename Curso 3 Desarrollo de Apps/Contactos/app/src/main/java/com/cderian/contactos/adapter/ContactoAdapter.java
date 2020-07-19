package com.cderian.contactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cderian.contactos.ContactoActivity;
import com.cderian.contactos.R;
import com.cderian.contactos.database.ConstructorContactos;
import com.cderian.contactos.pojo.Contacto;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdapter (ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    /**
     * Inflar el layout y lo pasará al ViewHolder para que él obtenga los views
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new ContactoViewHolder(view);
    }

    /**
     * Asocia cada elemento de la lista con cada view
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);
        holder.imgFotoCV.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.tvLikes.setText(contacto.getLikes() + " likes");

        holder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, ContactoActivity.class);
                intent.putExtra(v.getResources().getString(R.string.pnombre), contacto.getNombre());
                intent.putExtra(v.getResources().getString(R.string.ptelefono), contacto.getTelefono());
                intent.putExtra(v.getResources().getString(R.string.pemail), contacto.getEmail());
                intent.putExtra(v.getResources().getString(R.string.pfoto), contacto.getFoto());
                activity.startActivity(intent);
            }
        });

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorContactos constructor = new ConstructorContactos(activity);
                constructor.darLike(contacto);
                holder.tvLikes.setText(Integer.toString(constructor.obtenerLikes(contacto)));
            }
        });
    }

    /**
     * Cantidad de elementos que contiene la lista
     * @return
     */
    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private TextView tvLikes;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoCV = itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV = itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = itemView.findViewById(R.id.tvTelefonoCV);
            tvLikes = itemView.findViewById(R.id.tvLikes);
            btnLike = itemView.findViewById(R.id.btnLike);
        }
    }
}
