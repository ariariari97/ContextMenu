package menu.context.contextmenu;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.ContextMenu;
        import android.view.ContextMenu.ContextMenuInfo;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    // Define contacts
    String contacts[] = {"Ari", "Rizal", "Safik", "Satria"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView1 = (ListView) findViewById(R.id.listView1);
        // Create ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, contacts);
        listView1.setAdapter(adapter);

        // Register the ListView for Context menu
        registerForContextMenu(listView1);
    }

    // Create long clickable context menus
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Pilih Option");
        // groupId, itemId,  order, title
        menu.add(0, v.getId(), 0, "Panggil");
        menu.add(0, v.getId(), 0, "Kirim SMS");
        menu.add(0, v.getId(), 0, "Hapus Contact");

    }

    @Override
    // Create toast message if you want
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Panggil") {
            Toast.makeText(getApplicationContext(), "Memanggil Code",
                    Toast.LENGTH_LONG).show();
        } else if (item.getTitle() == "Kirim SMS") {
            Toast.makeText(getApplicationContext(), "Mengirim SMS",
                    Toast.LENGTH_LONG).show();
        } else {

            return false;
        }
        return true;

    }

}