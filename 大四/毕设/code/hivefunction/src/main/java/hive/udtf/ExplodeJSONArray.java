package hive.udtf;

import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.PrimitiveObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorUtils;
import org.json.JSONArray;

import java.util.ArrayList;

public class ExplodeJSONArray extends GenericUDTF {

    private PrimitiveObjectInspector inputOI;

    @Override
    public void close() throws HiveException {
    }

    /**
     * 限定函数IO类型. 接收参数类型,校验,类型不符,抛出异常
     *
     * @param argOIs
     * @return
     * @throws UDFArgumentException
     */
    @Override
    public StructObjectInspector initialize(ObjectInspector[] argOIs) throws UDFArgumentException {
        // 校验 UDTF 输入参数的合法性

        // 1. 校验参数个数
        if (argOIs.length != 1) {
            throw new UDFArgumentException("explode_json_array函数只能接收 1个参数");
        }

        // 2. 校验参数类型
        ObjectInspector argOI = argOIs[0];
        // 是否基本数据类型
        if (argOI.getCategory() != ObjectInspector.Category.PRIMITIVE) {
            throw new UDFArgumentException("explode_json_array函数只能接收 基本数据类型参数");
        }
        // 是基本数据类型 强转为基本数据类型
        PrimitiveObjectInspector primitiveOI = (PrimitiveObjectInspector) argOI;
        inputOI = primitiveOI;
        // 是否 String 类型
        if (primitiveOI.getPrimitiveCategory() != PrimitiveObjectInspector.PrimitiveCategory.STRING) {
            throw new UDFArgumentException("explode_json_array函数只能接收 STRING类型参数");
        }

        ArrayList<String> fieldNames = new ArrayList<String>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<ObjectInspector>();
        fieldNames.add("item"); // 后续sql加载数据时定义的列名会覆盖该列名
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames,
                fieldOIs);
    }

    /**
     * 处理数据逻辑
     * 处理每行数据,一行调用一次,遍历一行输出多行. 每行:遍历json数组,循环调用forward(),一个元素输出一行
     *
     * @param args
     * @throws HiveException
     */
    @Override
    public void process(Object[] args) throws HiveException {
        Object arg = args[0]; // initialize()已校验 可安全获取
        String jsonArrayStr = PrimitiveObjectInspectorUtils.getString(arg, inputOI);
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            String json = jsonArray.getString(i);
            String[] rst = {json};
            forward(rst);
        }
    }
}
