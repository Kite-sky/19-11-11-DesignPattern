import javax.swing.JComboBox;

public class Provinces {

    private static JComboBox prvc = new JComboBox();;

    public static JComboBox getPrvcList(String country){

		if(country.equals("Canada")){
		   prvc.addItem("New Brunswick");
		   prvc.addItem("Nova Scotia");
		   prvc.addItem("Ontario");
		   prvc.addItem("Québec");
		   prvc.addItem("Manitoba");
		   prvc.addItem("British Columbia");
		   prvc.addItem("Prince Edward Island");
		   prvc.addItem("Alberta");
		   prvc.addItem("Saskatchewan");
		   prvc.addItem("Newfoundland-Labrador");
		   prvc.addItem("Northwest Territories");
		   prvc.addItem("Yukon Territory");
		   prvc.addItem("Nunavut Territory");

		}
		else if (country.equals("USA")) {
		   prvc.addItem("Alabama");
		   prvc.addItem("Alaska ");
		   prvc.addItem("Arizona");
		   prvc.addItem("Arkansas");
		   prvc.addItem("California");
		   prvc.addItem("Colorado");
		   prvc.addItem("Connecticut");
		   prvc.addItem("Delaware");
		   prvc.addItem("District of Columbia");
		   prvc.addItem("Florida");
		   prvc.addItem("Georgia");
		   prvc.addItem("Hawaii");
		   prvc.addItem("Idaho");
		   prvc.addItem("Illinois");
		   prvc.addItem("Indiana");
		   prvc.addItem("Iowa");
		   prvc.addItem("Kansas");
		   prvc.addItem("Kentucky");
		   prvc.addItem("Louisiana");
		   prvc.addItem("Maine");
		   prvc.addItem("Maryland");
		   prvc.addItem("Massachusetts");
		   prvc.addItem("Michigan");
		   prvc.addItem("Minnesota");
		   prvc.addItem("Mississippi");
		   prvc.addItem("Missouri");
		   prvc.addItem("Montana");
		   prvc.addItem("Nebraska");
		   prvc.addItem("Nevada");
		   prvc.addItem("New Hampshire");
		   prvc.addItem("New Jersey");
		   prvc.addItem("New Mexico");
		   prvc.addItem("New York");
		   prvc.addItem("North Carolina");
		   prvc.addItem("North Dakota");
		   prvc.addItem("Ohio");
		   prvc.addItem("Oklahoma");
		   prvc.addItem("Oregon");
		   prvc.addItem("Pennsylvania");
		   prvc.addItem("Rhode Island");
		   prvc.addItem("South Carolina");
		   prvc.addItem("South Dakota");
		   prvc.addItem("Texas");
		   prvc.addItem("Utah");
		   prvc.addItem("Vermont");
		   prvc.addItem("Virginia");
		   prvc.addItem("Virgin Islands");
		   prvc.addItem("Washington");
		   prvc.addItem("West Virginia");
		   prvc.addItem("Wisconsin");
		   prvc.addItem("Wyoming");
		}

		else if (country.equals("China")){
           prvc.addItem("河北");
		   prvc.addItem("河南");
		   prvc.addItem("陜西");
		   prvc.addItem("山西");
		   prvc.addItem("山东");
		   prvc.addItem("甘肃");
		   prvc.addItem("辽宁");
		   prvc.addItem("黑龙江");
		   prvc.addItem("云南");
		   prvc.addItem("贵州");
		   prvc.addItem("福建");
		   prvc.addItem("广东");
		   prvc.addItem("海南");
		   prvc.addItem("台湾");
		   prvc.addItem("四川");
		   prvc.addItem("湖北");
		   prvc.addItem("湖南");
		   prvc.addItem("江西");
		   prvc.addItem("安徽");
		   prvc.addItem("江苏");
		   prvc.addItem("浙江");
		   prvc.addItem("青海");
		   prvc.addItem("新疆维吾尔族自治区");
		   prvc.addItem("内蒙古自治区");
		   prvc.addItem("宁夏回族自治区");
		   prvc.addItem("西藏自治区");
		   prvc.addItem("广西壮族自治区");
		   prvc.addItem("北京市");
		   prvc.addItem("天津市");
		   prvc.addItem("重庆市");
		   prvc.addItem("上海市");
		   prvc.addItem("澳门 ");
		   prvc.addItem("香港");
		   prvc.addItem("台湾");
		}
	   return prvc;
	}
}
