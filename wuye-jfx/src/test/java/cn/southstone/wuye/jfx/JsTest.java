package cn.southstone.wuye.jfx;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



/**
 * Created by fengs on 2016/8/23.
 */
public class JsTest {

    @Test
    public void test1(){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name = "Mahesh";

        Integer result = null;
        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
        }catch(ScriptException e){
            System.out.println("Error executing script: "+ e.getMessage());
        }
        System.out.println(result.toString());
    }

    @Test
    public void test2(){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name = "Mahesh";

        String sample1=" var Foo = Java.type('cn.southstone.wuye.jfx.Foo');var foo = new Foo();foo.setA(5.0);foo.setB(2.0);foo.sum();";
        double result1=0;
        double result2=0;

        double a=3.0;
        double b=4.0;

        String sample2=" var Foo = Java.type('cn.southstone.wuye.jfx.Foo');";
        sample2 += "var a="+a+",b="+b+";";
        sample2+="foo.sum1(a,b);";
        try {
           result1 = (double) nashorn.eval(sample1);
            result2 = (double) nashorn.eval(sample2);
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        System.out.print(result1);
        System.out.print(result2);
    }
}
