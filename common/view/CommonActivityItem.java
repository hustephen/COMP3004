
// 显示 spinner
ArrayAdapter adapter = new ArrayAdapter(this_, android.R.layout.simple_spinner_item, strings);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
sectionSp.setAdapter(adapter);


        ManagerComm.planList = GsonUtil.getInstance().fromJson(ManagerConf.readFromLocal("plan"), new TypeToken<List<Plan>>() {
        }.getType());
        if (ManagerComm.planList == null) {
        ManagerComm.planList = new ArrayList<Plan>();
        }

        listview.setAdapter(new CommonAdapter<Plan>(this_, ManagerComm.planList, R.layout.item_plan) {
@Override
public void convert(ViewHolder helper, Plan item) {
        helper.setText(R.id.type_tv, item.getType());
        helper.setText(R.id.count_tv, "每天复习 "+item.getCount()+ "个单词");
        helper.setText(R.id.day_tv, "共需要 "+item.getDay()+" 天完成");
        }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this_,ReviewActivity.class).putExtra("item",ManagerComm.planList.get(position)));
        }
        });


