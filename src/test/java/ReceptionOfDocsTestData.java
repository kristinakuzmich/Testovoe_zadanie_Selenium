import org.testng.annotations.DataProvider;
public class ReceptionOfDocsTestData {
    static String businessProcess ="Прием по документам";
    static String userName="Кузьмич Кристина Игоревна";
    @DataProvider(name="testdata")
    public Object[][]dataSet(){
        return new Object[][]
                {
                        {businessProcess,"Белорусский рубль",100,"Оплата по Договору","Платеж физического лица за приобретаемое",userName},
                };
    }
}
