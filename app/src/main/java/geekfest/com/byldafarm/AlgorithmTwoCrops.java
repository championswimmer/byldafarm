package geekfest.com.byldafarm;

import java.util.ArrayList;

/**
 * Created by raghav on 27/04/15.
 */
public class AlgorithmTwoCrops {

    public static FarmCalculationResult efficientFarm(int budget, double farmArea, ArrayList<Crop> crop) {
        FarmCalculationResult farmCalculationResult = new FarmCalculationResult();
        double area = (double) farmArea;

        int crop1CostPrice = 0;
        int crop1SellingPrice = 0;
        int crop2CostPrice = 0;
        int crop2SellingPrice = 0;
        int crop3CostPrice = 0;
        int crop3SellingPrice = 0;
        double max = 0.0;


        double totalCostPrice = 0.0, totalSellingPrice = 0.0;

        for (int a = 0; a < crop.size(); a++) {
            if (a == 0) {
                crop1CostPrice = crop.get(a).costPrice;
                crop1SellingPrice = crop.get(a).sellingPrice;
            } else if (a == 1) {
                crop2CostPrice = crop.get(a).costPrice;
                crop2SellingPrice = crop.get(a).sellingPrice;
            } else if (a == 2) {
                crop3CostPrice = crop.get(a).costPrice;
                crop3SellingPrice = crop.get(a).sellingPrice;
            }
        }

        for (int i = 0; i <= 100; i++) {

            for (int j = 0; j + i <= 100; j++) {

                totalCostPrice = crop1CostPrice * i * area / 100 + crop2CostPrice * (j) * area / 100 + crop3CostPrice * (100 - i - j) * area / 100;
//                System.out.println(i + " " + j + " " + (100 -i -j));

                if (totalCostPrice <= budget) {

                    totalSellingPrice = crop1SellingPrice * i * area / 100 + crop2SellingPrice * (j) * area / 100 + crop3SellingPrice * (100 - i - j) * area / 100;

                    if (totalSellingPrice - totalCostPrice > max) {
                        max = totalSellingPrice - totalCostPrice;
                        farmCalculationResult.maxAreaCrop1 = i * area / 100;
                        farmCalculationResult.maxAreaCrop2 = (j) * area / 100;
                        farmCalculationResult.maxAreaCrop3 = (100 - i - j) * area / 100;
                        farmCalculationResult.totalCost = totalCostPrice;
                        farmCalculationResult.totalProfit = max;
                        farmCalculationResult.areaUsed = area;
                        System.out.println(farmCalculationResult.totalProfit + " " + farmCalculationResult.maxAreaCrop1 + " " + farmCalculationResult.maxAreaCrop2 + " " + farmCalculationResult.maxAreaCrop3 + " " + farmCalculationResult.totalCost);
                    }
                }
                //175421.0 18.25 0.0 119889.0
            }
        }
        if(farmCalculationResult.totalProfit == 0.0){
            return efficientFarm(budget, area * 99.0/100.0, crop);
        }
        return farmCalculationResult;
    }

//    public static void main(String[] args){
//        Scanner s = new Scanner(System.in);
//        //    int bugdet = s.nextInt();
//        //      int noOfCrops = s.nextInt();
////        int area = s.nextInt();
//
//        int crop1sellingprice, crop2sellingprice, crop3sellingprice, crop1costprice, crop2costprice, crop3costprice;
//
//
//
//
//        FarmCalculationResult farmCalculationResult = efficientFarm(120000, 25);
//
//        System.out.println(farmCalculationResult.totalProfit + " " + farmCalculationResult.maxAreaCrop1 + " " + farmCalculationResult.maxAreaCrop2 + " " + farmCalculationResult.maxAreaCrop3 + " " +farmCalculationResult.totalCost);
////        System.out.println(maxProf + " " + (maxcrop1Area/100)*area + " " + (maxcrop2Area/100)*area + " " + (maxcrop3Area/100)*area);
//    }

}


