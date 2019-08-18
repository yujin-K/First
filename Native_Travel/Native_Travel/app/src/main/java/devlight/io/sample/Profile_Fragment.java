package devlight.io.sample;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;


public class Profile_Fragment extends Fragment {

    private ListView ListView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.profile, container, false);



        // 검색창 생성
        EditText txt_search;
        final ListView listview_custom = (ListView) rootView.findViewById(R.id.listView);
        txt_search = (EditText) rootView.findViewById(R.id.txt_search);

        txt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) { }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) { }
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString() ;
                if (filterText.length() > 0) {
                    listview_custom.setFilterText(filterText) ;
                } else {
                    listview_custom.clearTextFilter() ;
                }

            }
        });


        /* 위젯과 멤버변수 참조 획득 */
        ListView = (ListView) rootView.findViewById(R.id.listView);

        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();


        return rootView;
    }

    private void dataSetting () {

        MyAdapter mMyAdapter = new MyAdapter();


        for (int i = 0; i < 10; i++) {
            mMyAdapter.addItem(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.yujin), "name_" + i, "contents_" + i);
        }

        /* 리스트뷰에 어댑터 등록 */
        ListView.setAdapter(mMyAdapter);
    }



}


