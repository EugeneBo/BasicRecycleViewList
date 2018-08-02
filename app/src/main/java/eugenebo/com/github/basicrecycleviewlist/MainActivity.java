package eugenebo.com.github.basicrecycleviewlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        ItemAdapter itemAdapter = new ItemAdapter(contactListGenerator());

        recyclerView.setAdapter(itemAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

    }

    private List<ItemView> contactListGenerator() {

        List<ItemView> items = new ArrayList<>();
        String description = getResources().getString(R.string.description);

        for (int i = 0; i < 10; i++) {

            items.add(new Header("Friends"));

            items.add(new Contact("Ryan Gosling", description));
            items.add(new Contact("Ryan Gosling", description));
            items.add(new Contact("Winona Ryder", description));
            items.add(new Contact("Winona Ryder", description));

            items.add(new Header("Colleges"));

            items.add(new Contact("Wanana Vader", description));
            items.add(new Contact("Wanana Vader", description));
            items.add(new Contact("Ryan Gosling", description));
            items.add(new Contact("Keith", description));
            items.add(new Contact("Thomas Alan Waits", description));
            items.add(new Contact("Natalie Portman", description));
            items.add(new Contact("Mick Jagger", description));
            items.add(new Contact("Jim Morrison", description));
            items.add(new Contact("Charlie Sheen", description));
            items.add(new Contact("Tom Hanks", description));
            items.add(new Contact("Emma Stone", description));
            items.add(new Contact("Sergey Stilov", description));

            items.add(new Header("Relatives"));

            items.add(new Contact("Roger Waters", description));
            items.add(new Contact("Billie Armstrong", description));
            items.add(new Contact("Miles Davis", description));
            items.add(new Contact("Chet Baker", description));
            items.add(new Contact("Michael", description));
            items.add(new Contact("Mike Shinoda", description));
            items.add(new Contact("Jean Reno", description));
            items.add(new Contact("Lawrence Ellison", description));
            items.add(new Contact("Ilon Mask", description));
            items.add(new Contact("Winona Ryder", description));

            items.add(new Header("Service"));

            items.add(new Contact("Winona Ryder", description));
            items.add(new Contact("Ryan Gosling", description));
            items.add(new Contact("Ryan Gosling", description));
            items.add(new Contact("Keith", description));
            items.add(new Contact("Thomas Alan Waits", description));
            items.add(new Contact("Natalie Portman", description));
            items.add(new Contact("Mick Jagger", description));
            items.add(new Contact("Jim Morrison", description));
            items.add(new Contact("Charlie Sheen", description));
            items.add(new Contact("Tom Hanks", description));
            items.add(new Contact("Emma Stone", description));

            items.add(new Header("Favorite"));

            items.add(new Contact("Sergey Stilov", description));
            items.add(new Contact("Roger Waters", description));
            items.add(new Contact("Billie Armstrong", description));
            items.add(new Contact("Miles Davis", description));
            items.add(new Contact("Chet Baker", description));
            items.add(new Contact("Michael", description));
            items.add(new Contact("Mike Shinoda", description));
            items.add(new Contact("Jean Reno", description));
            items.add(new Contact("Lawrence Ellison", description));
            items.add(new Contact("zilon zask", description));

        }

        return items;
    }

}
