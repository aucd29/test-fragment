package com.example.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fragment.control.ViewManager;
import com.example.fragment.view.MainFrgmt;
import com.example.fragment.view.Sub2Frgmt;
import com.example.fragment.view.SubFrgmt;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.list)
    ListView mList;

    private ArrayList<Menu> mMenuList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initMenuList();
        initList();
        initFrgmt();
    }

    private void initMenuList() {
        mMenuList.add(new Menu(MainFrgmt.class.getSimpleName()));
        mMenuList.add(new Menu(SubFrgmt.class.getSimpleName()));
        mMenuList.add(new Menu(Sub2Frgmt.class.getSimpleName()));
    }

    private void initList() {
        mList.setAdapter(new MenuAdapter());
        mList.setOnItemClickListener((parent, view, position, id) -> {
            Log.d(TAG, "POS : " + position);

            switch (position) {
                case 0:
                    ViewManager.getInstance().add(R.id.frgmt_base, MainFrgmt.class);
                    break;
                case 1:
                    ViewManager.getInstance().add(R.id.frgmt_base, SubFrgmt.class);
                    break;
                case 2:
                    ViewManager.getInstance().add(R.id.frgmt_base, Sub2Frgmt.class);
                    break;
                default:
                    break;
            }
        });
    }

    private void initFrgmt() {
        ViewManager.getInstance().setFragmentManager(this);
        ViewManager.getInstance().add(R.id.frgmt_base, MainFrgmt.class);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //
    // DATA
    //
    ////////////////////////////////////////////////////////////////////////////////////

    class Menu {
        String name;

        public Menu(String name) {
            this.name = name;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //
    // ADAPTER
    //
    ////////////////////////////////////////////////////////////////////////////////////

    class ViewHolder {
        TextView name;
    }

    class MenuAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return mMenuList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh;

            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.main_menu_item, null);
                vh = new ViewHolder();

                vh.name = ButterKnife.findById(convertView, R.id.menu);

                convertView.setTag(vh);
            } else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.name.setText(mMenuList.get(position).name);

            return convertView;
        }
    }
}
