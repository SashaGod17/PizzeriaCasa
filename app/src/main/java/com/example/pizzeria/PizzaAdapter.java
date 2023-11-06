package com.example.pizzeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {

    private ArrayList<Pizza> arrayPizzas;

    public PizzaAdapter(ArrayList<Pizza> pizzas){
        this.arrayPizzas = pizzas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View pizzaView = inflater.inflate(R.layout.layout_pizza,parent,false);

        ViewHolder viewHolder = new ViewHolder(pizzaView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Pizza pizza = arrayPizzas.get(position);


        ImageView img = holder.imgPizza;
        img.setImageResource(R.drawable.pizza_default);

        TextView txtNombrePizza = holder.txtNombrePizza;
        txtNombrePizza.setText(pizza.getNombre() + "\n" +"\n");
        ArrayList<Ingrediente> ingredientes = pizza.getIngredientes();
        for (Ingrediente i : ingredientes){
            txtNombrePizza.setText(txtNombrePizza.getText() + i.toString() + ", " );
        }

    }

    @Override

    public int getItemCount() {
        return arrayPizzas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgPizza;
        public TextView txtNombrePizza;


        public ViewHolder(View itemView){
            super(itemView);

            imgPizza = (ImageView) itemView.findViewById(R.id.imgPizza);
            txtNombrePizza = (TextView) itemView.findViewById(R.id.txtNombrePizza);

        }
    }

}
