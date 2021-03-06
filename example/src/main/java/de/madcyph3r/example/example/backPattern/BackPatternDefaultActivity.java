package de.madcyph3r.example.example.backPattern;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import de.madcyph3r.example.R;
import de.madcyph3r.example.example.FragmentDummy;
import de.madcyph3r.example.example.FragmentInstruction;
import de.madcyph3r.materialnavigationdrawer.MaterialNavigationDrawer;
import de.madcyph3r.materialnavigationdrawer.head.MaterialHeadItem;
import de.madcyph3r.materialnavigationdrawer.menu.MaterialMenu;
import de.madcyph3r.materialnavigationdrawer.menu.item.MaterialSection;
import de.madcyph3r.materialnavigationdrawer.tools.RoundedCornersDrawable;

/**
 * Created by marc on 23.02.2015.
 */
public class BackPatternDefaultActivity extends MaterialNavigationDrawer {

    MaterialNavigationDrawer drawer = null;

    @Override
    public int headerType() {
        // set type. you get the available constant from MaterialNavigationDrawer class
        return MaterialNavigationDrawer.DRAWERHEADER_NO_HEADER;
    }

    @Override
    public void init(Bundle savedInstanceState) {

        Bundle bundle = new Bundle();
        bundle.putString("instruction", "Default back pattern. It only calls super.onBackPressed() .");

        drawer = this;

        MaterialMenu menu = new MaterialMenu();

        Fragment fragmentInstruction = new FragmentInstruction();
        fragmentInstruction.setArguments(bundle);

        // create menu items
        MaterialSection instruction = this.newSection("Instruction", fragmentInstruction , false, menu);
        instruction.setFragmentTitle("Default Back Pattern");
        this.newSection("Section 1", new FragmentDummy(), false, menu);
        this.newSection("Section 2",  new FragmentDummy(), false, menu);
        this.newSection("Section 3", new FragmentDummy(), false, menu);

        // set menu
        this.setCustomMenu(menu);

        // set pattern
        this.setBackPattern(MaterialNavigationDrawer.BACKPATTERN_BACK_ANYWHERE);
    }
}
