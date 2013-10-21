package com.example.alab1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ListView contactText;
	private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        contactText = (ListView)findViewById(R.id.contactText1);
        addButton = (Button)findViewById(R.id.button1);
        
        setUpListView();
        
        addButton.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
//				contactList.add(new Contact("dj", "dj", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
//				Log.i("Lab2", "There are" + contactList.size() + "contacts");
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, AddContactActivity.class);
		    	startActivity(intent);
				// Update display
				((BaseAdapter) contactText.getAdapter()).notifyDataSetChanged();
			}

			       	
        });
    }
    
    private List<Contact> contactList = new ArrayList<Contact>();
    
    private void setUpListView(){
    	
    	contactList.add(new Contact("'James", "Unit", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Aaron", "Barbosa", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Anderson", "Kim", "17 Dire Road", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Aradnia", "Knowles", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Axle", "Hunter", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Aztec", "Wood", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Billy", "Bob", "17 Dire Road", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Burt", "Gee", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Coolio", "Hernandez", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Dalvin", "Rosales", "17 Dire Road", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Gary", "Pancito", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	contactList.add(new Contact("Roberto", "Lim", "7 Radiant Place", "asdbbf@hotmail.co.nz", "8276543", "0227654321", "0800304050", "09/09/1923"));
    	
    	ListAdapter listAdapter = new CustomListAdapter();
    	contactText.setAdapter(listAdapter);
    	
    	// Anonymous adapter
    	contactText.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    	
	    	@Override
			public void onItemClick(AdapterView<?> parentView, View clickedView, int clickedViewPosition,
					long id) {
				// TODO Auto-generated method stub
				final Contact selectedContact = contactList.get(clickedViewPosition);
	    		
	    		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
				
				dialogBuilder.setTitle(selectedContact.getFirstName() + " " + selectedContact.getSurName());
//				dialogBuilder.setMessage();
				dialogBuilder.setNegativeButton("Delete", new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
						contactList.remove(selectedContact);
						((BaseAdapter) contactText.getAdapter()).notifyDataSetChanged();
					}
							
				});

				dialogBuilder.setPositiveButton("View", new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent();
						intent.setClass(MainActivity.this, ViewContact.class);
						intent.putExtra("object", selectedContact);
				    	startActivity(intent);
						
					}
					
				});
				dialogBuilder.create().show();
			}
    	});
    	
    }
    
    private class CustomListAdapter extends ArrayAdapter<Contact>{
    	
    	CustomListAdapter(){
    		super(MainActivity.this, android.R.layout.simple_list_item_1, contactList);
    		
    	}
    
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent){
    	LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    	
    	View listItemView = inflater.inflate(R.layout.custom_list_item_layout, null);
    	
    	TextView name =(TextView)listItemView.findViewById(R.id.list_item_text_name);
    	TextView add1 =(TextView)listItemView.findViewById(R.id.list_item_text_add1);
    	TextView email1 =(TextView)listItemView.findViewById(R.id.list_item_text_email1);
    	TextView homeNum =(TextView)listItemView.findViewById(R.id.list_item_text_homeNum);
    	TextView mobileNum =(TextView)listItemView.findViewById(R.id.list_item_text_mobileNum);
    	TextView workNum =(TextView)listItemView.findViewById(R.id.list_item_text_workNum);
    	TextView dob =(TextView)listItemView.findViewById(R.id.list_item_text_dob);
//    	
    	name.setText(contactList.get(position).getFirstName() + " " + contactList.get(position).getSurName());
//    	add1.setText(contacts.get(position).getAddress());
//    	add2.setText(contacts.get(position).getAlternativeAdd());
//    	email1.setText(contacts.get(position).getEmail());
//    	email2.setText(contacts.get(position).getAlternativeEmail());
//    	homeNum.setText(contacts.get(position).getHomeNum());
//    	mobileNum.setText(contacts.get(position).getMobileNum());
//    	workNum.setText(contacts.get(position).getWorkNum());
//    	dob.setText(contacts.get(position).getDob());
    	
    	return listItemView;
    	
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
