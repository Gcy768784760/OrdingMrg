import java.util.Scanner;


public class OrderingMgr {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		
		String[] name = new String[4]; 							//保存订餐人姓名
		String[] dishMegs = new String[4];						//保存菜品
		int[] copies = new int[4];								//保存所选份数
		int[] time = new int[4];								//保存送餐时间
		String[] addresses = new String[4];						//保存送餐地址
		int[] states = new int[4];								//保存订单状态：0表示已预定 1表示已完成
		double[] sumPrices = new double[4];						//保存总金额
		String[] dishNames = {"红烧带鱼","鱼香肉丝","时令鲜蔬"};	//菜品名称
		double[] prices = new double[]{38.0,20.0,10.0};			//菜品单价
		int[] praiseNums = new int[3];							//点赞数
		int i = 0;
		
		for(boolean flag=false;flag==false;){
			System.out.println("欢迎使用“吃货联盟订餐系统”");
			System.out.println("***************************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐袋");
			System.out.println("3、签收订单");
			System.out.println("4、删除订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("***************************");
			System.out.println("请选择:");
			int x = input.nextInt();
			switch(x){
			case 1:
				if(i >= 4){
					System.out.println("当前订单已满，请稍后");
				}else{	
					for(;i<4;i++){
						System.out.println("****我要订餐****");
						System.out.println("请输入订餐人姓名:");
						name[i] = input.next();
						System.out.println("序号\t\t菜名\t\t单价\t\t点赞数");
						for(int j=1;j<=3;j++){
							System.out.println(j+"\t\t" +dishNames[j-1]+ "\t\t" +prices[j-1]+ "元\t\t" +praiseNums[j-1]);
						}
						System.out.println("请输入您要点的菜品编号:");
						int dishnum = input.nextInt();
						System.out.println("请输入您要的数量:");
						copies[i] = input.nextInt();
						System.out.println("请输入送餐时间(送餐时间为10点到20点整):");
						time[i] = input.nextInt();
						System.out.println("请输入送餐地点:");
						addresses[i] = input.next();
						//判断是否输入有误
						while(true){
							if(dishnum > 3 || dishnum <1){
								System.out.println("您输入的菜品编号有误，请重新输入");
								System.out.println("请输入您要点的菜品编号:");
								dishnum = input.nextInt();
								System.out.println("请输入您要的数量:");
								copies[i] = input.nextInt();
								System.out.println("请输入送餐时间(送餐时间为10点到20点整):");
								time[i] = input.nextInt();
								System.out.println("请输入送餐地点:");
								addresses[i] = input.next();
							} else if(time[i] < 10 || time[i] > 20){
								System.out.println("不在送餐时间内，请重新输入");
								System.out.println("请输入您要点的菜品编号:");
								dishnum = input.nextInt();
								System.out.println("请输入您要的数量:");
								copies[i] = input.nextInt();
								System.out.println("请输入送餐时间(送餐时间为10点到20点整):");
								time[i] = input.nextInt();
								System.out.println("请输入送餐地点:");
								addresses[i] = input.next();
							} else {
								System.out.println("订餐成功！");
								break;
							}
						}
						//计算价格
						sumPrices[i] = prices[dishnum-1] * copies[i];
						dishMegs[i] = dishNames[dishnum-1];
						if(sumPrices[i] >= 50){
							System.out.println("您订的是:" +dishMegs[i]+ " " +copies[i]+ "份\n送餐时间:" +time[i]+ "\n餐费:" +sumPrices[i]+ "元\t送餐费:0.0元\t总计:"+sumPrices[i]+ "元");
						}else{
							sumPrices[i] += 5;
							System.out.println("您订的是:" +dishMegs[i]+ " " +copies[i]+ "份\n送餐时间:" +time[i]+ "\n餐费:" +sumPrices[i]+ "元\t送餐费:5.0元\t总计:"+sumPrices[i]+ "元");
						}
						//返回或继续
						System.out.println("输入0返回:");
						int a = input.nextInt();
						if(a == 0){
							break;
						}
					}
				}
				break;
			case 2:
				System.out.println("****查看餐袋****");
				System.out.println("序号\t\t订餐人\t\t餐品信息\t\t购买数量\t\t送餐时间\t\t送餐地点\t\t总金额\t\t订单状态\t\t");
				for(i=0;i<4;i++){
					if(name[i] !=null){
						System.out.println((i+1)+ "\t\t" +name[i]+ "\t\t" +dishMegs[i]+"\t\t"+copies[i]+"份\t\t" +time[i]+ "\t\t" +addresses[i]+ "\t\t" +sumPrices[i]+ "\t\t" +states[i]);
					}
				}
				break;
			case 3:
				System.out.println("****签收订单****");
				System.out.println("请选择要签收的订单序号:");
				int a = input.nextInt();
				if(name[a-1] != null && states[a-1] != 1){
					states[a-1] = 1;
					System.out.println("订单签收成功");
				}
				System.out.println("输入0返回:");
				a =input.nextInt();
				if(a==0){
					break;
				}
				break;
			case 4:
				System.out.println("****删除订单****");
				System.out.println("请选择要删除的订单:");
				a =input.nextInt();
				if(name[a-1] != null && states[a-1] ==1){
					for(a=a-1;a<3;a++){
						name[a] = name[a+1];
						dishMegs[a] = dishMegs[a+1];
						time[a] = time[a+1];
						addresses[a] = addresses[a+1];
						states[a] = states[a+1];
						sumPrices[a] = sumPrices[a+1];
					}
					System.out.println("删除订单成功!");
				}else if(name[a-1] == null){
					System.out.println("无操作");
				}else if(states[a-1] ==0){
					System.out.println("该订单未签收，不能执行删除操作");
				}
				System.out.println("输入0返回:");
				a =input.nextInt();
				if(a==0){
					break;
				}
				break;
			case 5:
				System.out.println("****我要点赞****");
				System.out.println("序号\t\t菜名\t\t单价\t\t点赞数");
				for(int j=1;j<=3;j++){
					System.out.println(j+"\t\t" +dishNames[j-1]+ "\t\t" +prices[j-1]+ "元\t\t" +praiseNums[j-1]);
				}
				while(true){
					System.out.println("请选择你要点赞的菜品序号:");
					a = input.nextInt();
					if(a >3 || a<1){
						System.out.println("输入错误");
					}else{
						praiseNums[a-1] +=1;
						break;
					}
				}
				break;
			case 6:
				flag = true;
				break;
			default:
				flag = true;
				break;
			}
		}
	}

}
