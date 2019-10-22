package javademo.zhujie;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("product")
public class Product {


    @Autowired
    private ProductEdit productEdit;
    @Autowired
    private ProductSave productSave;



    public void sell(){
        productSave.save();
        productEdit.edit();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Product product = (Product)applicationContext.getBean("product");
        product.sell();
    }
}
