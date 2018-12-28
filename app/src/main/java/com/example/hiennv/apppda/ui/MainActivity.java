package com.example.hiennv.apppda.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;

import android.os.Bundle;
import android.view.View;

import com.example.hiennv.apppda.R;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.itemanimators.AlphaCrossFadeAnimator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    //Drawer
    private Drawer result;
    //header
    private AccountHeader accountHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set toolbar
        setSupportActionBar(toolbar);

        //Profile
        IProfile profile = new ProfileDrawerItem().withName("Abc").withEmail("abc@gmail.com").withIcon("https://avatars3.githubusercontent.com/u/1476232?v=3&s=460")
                .withIdentifier(100);
        IProfile profile1 = new ProfileDrawerItem().withName("Xyz").withEmail("xyz@gmail.com").withIcon("https://avatars2.githubusercontent.com/u/3597376?v=3&s=460").withIdentifier(101);
        //Create header nav
        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withTranslucentStatusBar(true)
                //.withAccountHeader(R.layout.header_nav)
                .addProfiles(profile,
                        profile1,
                        //Add setting
                        new ProfileSettingDrawerItem().withName("Add Account").withDescription("Add new Github Account")
                                .withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_add).actionBar().paddingDp(5).colorRes(R.color.material_drawer_primary_text))
                                .withIdentifier(100000),
                        new ProfileSettingDrawerItem().withName("Manage Account").withIcon(GoogleMaterial.Icon.gmd_settings).withIdentifier(100001)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        //Event change profile
                        if (profile instanceof IDrawerItem && profile.getIdentifier() == 100000) {
                            //Add new Account
                            int count = 100 + accountHeader.getProfiles().size() + 1;
                            IProfile newProfile = new ProfileDrawerItem().withNameShown(true).withName("Batman" + count)
                                    .withEmail("batman" + count + "@gmail.com")
                                    .withIcon(R.drawable.ic_launcher_background).withIdentifier(count);
                            if (accountHeader.getProfiles() != null) {
                                //Add new profile
                                accountHeader.addProfile(newProfile, accountHeader.getProfiles().size() - 2);
                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();


        //Add drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .withItemAnimator(new AlphaCrossFadeAnimator()) //Add animation
                .withAccountHeader(accountHeader) //Add account header
                .addDrawerItems(
                        //Add title group
                        new SectionDrawerItem().withName(R.string.txt_inquiry).withDivider(false),
                        new PrimaryDrawerItem().withName("Menu 1")./*withDescription("Menu 11").*/withIcon(GoogleMaterial.Icon.gmd_brightness_5).withIdentifier(1).withSelectable(false),
                        new PrimaryDrawerItem().withName("Menu 2")./*withDescription("Menu 22").*/withIcon(FontAwesome.Icon.faw_home).withIdentifier(2).withSelectable(false),
                        new SectionDrawerItem().withName(R.string.txt_registration),
                        new SecondaryDrawerItem().withName("Menu 3")./*withDescription("Menu 33").*/withIcon(FontAwesome.Icon.faw_gamepad).withIdentifier(3).withSelectable(false),
                        new SecondaryDrawerItem().withName("Menu 4")./*withDescription("Menu 44").*/withIcon(FontAwesome.Icon.faw_eye).withIdentifier(4).withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        //Event click item
                        if (drawerItem != null) {
                            if (drawerItem.getIdentifier() == 1) {

                            } else if (drawerItem.getIdentifier() == 2) {

                            } else if (drawerItem.getIdentifier() == 3) {

                            } else if (drawerItem.getIdentifier() == 4) {

                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();
    }
}
