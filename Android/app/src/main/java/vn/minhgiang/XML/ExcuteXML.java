package vn.minhgiang.XML;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.FileInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import vn.minhgiang.list.R;

public class ExcuteXML extends AppCompatActivity {
   private Button btnLoadXMl;
    private  Spinner spTitle;
    private ListView lvDataXML;
    ArrayList<String> titles= new ArrayList<>();
    ArrayAdapter<String> arrayAdapterSpinner;
    ArrayList<String> data= new ArrayList<>();
    ArrayAdapter<String> arrayAdapterDataList;

    private void init()
    {
        btnLoadXMl=findViewById(R.id.btnLoadXML);
        spTitle=findViewById(R.id.spTitle);
        lvDataXML=findViewById(R.id.lvXML);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excute_xml);
        init();
        arrayAdapterSpinner=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,
                titles);
        spTitle.setAdapter(arrayAdapterSpinner);
        arrayAdapterDataList=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item
        ,data);
        lvDataXML.setAdapter(arrayAdapterDataList);
        btnLoadXMl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLfile();
                arrayAdapterDataList.notifyDataSetChanged();
                arrayAdapterSpinner.notifyDataSetChanged();
            }
        });
    }

    private void loadXMLfile() {
        try {
            titles.clear();
            data.clear();
            //Tao doi tuong DocumentBuilder

            DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder =fac.newDocumentBuilder();
            //Tao file Input Stream tu tep tin Nguon
            //b1 lay duong dan den SDCard
            String pathSDCard= Environment.getExternalStorageDirectory().getAbsolutePath();
            //Duong dan den file XMl
            String xmlfile="data/data//vn.minhgiang.list/employee.xml";
            FileInputStream fIn = new FileInputStream(xmlfile);
            //3 dung phuong thuc parse cua duong tuong builder de tao doccument
            Document doc = builder.parse(fIn);
            //4 duyet tung node trong file XML
            //Lay node goc
            Element root =doc.getDocumentElement();
            //lay toan bo node con cua root
            NodeList list = root.getChildNodes();
            //Duyet tu node dau tien den node cuoi cung
            for (int i=0;i<list.getLength();i++)
            {
                //moi lan duyet lay ra 1 node
                Node node = list.item(i);
                //Kiem tra xem node co phai la Element hay khong
                //vi ta dua vao de lay Element ben trong
                if (node instanceof Element)
                {
                    //lay phan tu co tag Employee
                    Element elementEmp= (Element) node;
                    //lay gia tri thuoc tinh Id
                    //id la thuoc tinh cua Tag Employee
                    String id = elementEmp.getAttribute("id");
                    //lay gia tri thuoc tinh Title
                    //Title la thuoc tinh cua TagEmployee
                    String title=elementEmp.getAttribute("title");
                    //lay tag name ben trong cua TagEmployee
                    NodeList listChild = elementEmp.getElementsByTagName("name");
                    NodeList listChild1=elementEmp.getElementsByTagName("phone");
                    //lay noi dung cua tagphone
                    //chi xu li item(0) vi chi co 1 tag phone trong Tag Employee
                    String name=listChild.item(0).getTextContent();
                    String phone=listChild1.item(0).getTextContent();
                    titles.add(title);
                    data.add(id+"  - "+name+" -  "+phone);
                }


            }
        }catch (Exception ex)
        {
            Log.e("ERROR", ex.getMessage());
        }
    }

}