import org.testng.annotations.DataProvider;
public class ReceptionOfDocsTestData {
    static String businessProcess ="Прием по документам";
    static String userName="Кузьмич Кристина Игоревна";
    String operIsOver=Messages.OPERATIONISOVER.getMessage();
    @DataProvider(name="testdata")
    public Object[][]dataSet(){
        return new Object[][]
                {
                        {businessProcess,"Белорусский рубль",100,"Оплата по Договору","Платеж физического лица за приобретаемое",userName,operIsOver},
                        {businessProcess,"Доллар США",250,"Уплата налогов","Налог на добычу полезных ископаемых",userName,operIsOver},
                        {businessProcess,"Евро",3000,"Осуществление юридическим лицом оплаты по договору","Земельный налог",userName,operIsOver},
                        {businessProcess,"Российский рубль",40,"Уплата задолженности","Налог на игорный бизнес",userName,operIsOver},
                };
    }
}
