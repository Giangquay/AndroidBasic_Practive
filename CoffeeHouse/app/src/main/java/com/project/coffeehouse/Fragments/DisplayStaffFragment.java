package com.project.coffeehouse.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;


import com.project.coffeehouse.Activities.AddStaffActivity;
import com.project.coffeehouse.Activities.HomeActivity;
import com.project.coffeehouse.CustomAdapter.AdapterDisplayStaff;
import com.project.coffeehouse.DAO.NhanVienDAO;
import com.project.coffeehouse.DTO.NhanVienDTO;
import com.project.coffeehouse.R;

import java.util.List;

public class DisplayStaffFragment extends Fragment {

    GridView gvStaff;
    NhanVienDAO nhanVienDAO;
    List<NhanVienDTO> nhanVienDTOS;
    AdapterDisplayStaff adapterDisplayStaff;

    ActivityResultLauncher<Intent> resultLauncherAdd = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        long ktra = intent.getLongExtra("ketquaktra",0);
                        String chucnang = intent.getStringExtra("chucnang");
                        if(chucnang.equals("themnv"))
                        {
                            if(ktra != 0){
                                HienThiDSNV();
                                Toast.makeText(getActivity(),"Th??m th??nh c??ng",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getActivity(),"Th??m th???t b???i",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            if(ktra != 0){
                                HienThiDSNV();
                                Toast.makeText(getActivity(),"S???a th??nh c??ng",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getActivity(),"S???a th???t b???i",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }
            });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.displaystaff_layout,container,false);
        ((HomeActivity)getActivity()).getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Qu???n l?? nh??n vi??n</font>"));
        setHasOptionsMenu(true);

        gvStaff = (GridView)view.findViewById(R.id.gvStaff) ;

        nhanVienDAO = new NhanVienDAO(getActivity());
        HienThiDSNV();

        registerForContextMenu(gvStaff);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.edit_context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri = menuInfo.position;
        int manv = nhanVienDTOS.get(vitri).getMANV();

        switch (id){
            case R.id.itEdit:
                Intent iEdit = new Intent(getActivity(), AddStaffActivity.class);
                iEdit.putExtra("manv",manv);
                resultLauncherAdd.launch(iEdit);
                break;

            case R.id.itDelete:
                boolean ktra = nhanVienDAO.XoaNV(manv);
                if(ktra){
                    HienThiDSNV();
                    Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.delete_sucessful)
                            ,Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getActivity(),getActivity().getResources().getString(R.string.delete_failed)
                            ,Toast.LENGTH_SHORT).show();
                }
                break;
        }

        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem itAddStaff = menu.add(1,R.id.itAddStaff,1,"Th??m nh??n vi??n");
        itAddStaff.setIcon(R.drawable.ic_baseline_add_24);
        itAddStaff.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itAddStaff:
                Intent iDangky = new Intent(getActivity(), AddStaffActivity.class);
                resultLauncherAdd.launch(iDangky);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void HienThiDSNV(){
        nhanVienDTOS = nhanVienDAO.LayDSNV();
        adapterDisplayStaff = new AdapterDisplayStaff(getActivity(),R.layout.custom_layout_displaystaff,nhanVienDTOS);
        gvStaff.setAdapter(adapterDisplayStaff);
        adapterDisplayStaff.notifyDataSetChanged();
    }
}
