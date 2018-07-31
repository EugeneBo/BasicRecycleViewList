package eugenebo.com.github.basicrecycleviewlist;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TEST";
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = contactListGenerator();
        for (Contact contact : contacts) {
            setContactAvatarLetters(contact);
            //randomColorGenerator(contact);
            colorGenerator(contact);
        }

        ContactAdapter contactAdapter = new ContactAdapter(contacts, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(contactAdapter);

    }

    private List<Contact> contactListGenerator() {

        List<Contact> contacts = new ArrayList<>();
        String description = getResources().getString(R.string.description);

        contacts.add(new Contact("Ryan Gosling", description));
        contacts.add(new Contact("Ryan Gosling", description));
        contacts.add(new Contact("Winona Ryder", description));
        contacts.add(new Contact("Winona Ryder", description));
        contacts.add(new Contact("Wanana Vader", description));
        contacts.add(new Contact("Wanana Vader", description));
        contacts.add(new Contact("Ryan Gosling", description));
        contacts.add(new Contact("Keith", description));
        contacts.add(new Contact("Thomas Alan Waits", description));
        contacts.add(new Contact("Natalie Portman", description));
        contacts.add(new Contact("Mick Jagger", description));
        contacts.add(new Contact("Jim Morrison", description));
        contacts.add(new Contact("Charlie Sheen", description));
        contacts.add(new Contact("Tom Hanks", description));
        contacts.add(new Contact("Emma Stone", description));
        contacts.add(new Contact("Sergey Stilov", description));
        contacts.add(new Contact("Roger Waters", description));
        contacts.add(new Contact("Billie Armstrong", description));
        contacts.add(new Contact("Miles Davis", description));
        contacts.add(new Contact("Chet Baker", description));
        contacts.add(new Contact("Michael", description));
        contacts.add(new Contact("Mike Shinoda", description));
        contacts.add(new Contact("Jean Reno", description));
        contacts.add(new Contact("Lawrence Ellison", description));
        contacts.add(new Contact("Ilon Mask", description));

        contacts.add(new Contact("Winona Ryder", description));
        contacts.add(new Contact("Winona Ryder", description));
        contacts.add(new Contact("Ryan Gosling", description));
        contacts.add(new Contact("Ryan Gosling", description));
        contacts.add(new Contact("Keith", description));
        contacts.add(new Contact("Thomas Alan Waits", description));
        contacts.add(new Contact("Natalie Portman", description));
        contacts.add(new Contact("Mick Jagger", description));
        contacts.add(new Contact("Jim Morrison", description));
        contacts.add(new Contact("Charlie Sheen", description));
        contacts.add(new Contact("Tom Hanks", description));
        contacts.add(new Contact("Emma Stone", description));
        contacts.add(new Contact("Sergey Stilov", description));
        contacts.add(new Contact("Roger Waters", description));
        contacts.add(new Contact("Billie Armstrong", description));
        contacts.add(new Contact("Miles Davis", description));
        contacts.add(new Contact("Chet Baker", description));
        contacts.add(new Contact("Michael", description));
        contacts.add(new Contact("Mike Shinoda", description));
        contacts.add(new Contact("Jean Reno", description));
        contacts.add(new Contact("Lawrence Ellison", description));
        contacts.add(new Contact("zilon zask", description));


        for (Contact c : contacts) {
            int i = 2 * Math.abs((byte) c.hashCode());
            Log.i(TAG, "HASH: " + i);
        }

        return contacts;
    }

    private void randomColorGenerator(Contact contact) {
        Random rnd = new Random();
        contact.setAvatarColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
    }

    private void colorGenerator(Contact contact) {
        int red = 2 * Math.abs((byte) contact.hashCode());
        int green;
        int blue;

        if (red % 2 == 0) {
            green = 90;
            blue = 50;
        } else if (red % 3 == 0) {
            green = 150;
            blue = 75;
        } else {
            green = 60;
            blue = 125;
        }

        Log.i(TAG, "COLOR: " + Color.argb(255, red, green, blue));
        contact.setAvatarColor(Color.argb(255, red, green, blue));

    }

    private void setContactAvatarLetters(Contact contact) {
        String[] strings = contact.getName().trim().split("\\s+");

        if (strings.length >= 2) {
            contact.setAvatarLetters(strings[0].substring(0, 1) + strings[1].substring(0, 1));
        } else if (strings.length == 1) {
            contact.setAvatarLetters(strings[0].substring(0, 1));
        } else contact.setAvatarLetters("N/A");

    }
}
