package ra.entity;

import ra.run.Main;

import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Laptop {
    private String laptopId;
    private String laptopName;
    private String description;
    private int ram;
    private double weight;
    private String customerAddress;
    private double laptopPrice;
    private int typeId;
    private boolean isDelete;

    public Laptop() {
    }

    public Laptop(String laptopId, String laptopName, String description, int ram, double weight, String createAt, double laptopPrice, int typeId, boolean isDelete) {
        this.laptopId = laptopId;
        this.laptopName = laptopName;
        this.description = description;
        this.ram = ram;
        this.weight = weight;
        this.customerAddress = createAt;
        this.laptopPrice = laptopPrice;
        this.typeId = typeId;
        this.isDelete = isDelete;
    }

    public String getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(String laptopId) {
        this.laptopId = laptopId;
    }

    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public double getLaptopPrice() {
        return laptopPrice;
    }

    public void setLaptopPrice(double laptopPrice) {
        this.laptopPrice = laptopPrice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public void inputData(Scanner scanner) {
        this.laptopId = inputLaptopId(scanner);
        this.laptopName = inputLaptopName(scanner);
        this.description = inputDescription(scanner);
        this.customerAddress = inputCustomerAddress(scanner);
        this.ram = inputRam(scanner);
        this.weight = inputWeight(scanner);
        this.laptopPrice = inputPrice(scanner);
        this.typeId = inputTypeId(scanner);
        this.isDelete = isDelete();
    }

    public String inputLaptopId(Scanner scanner) {
        System.out.println("Mời nhập mã laptop:");
        String laptopRegex = "L[\\w]{4}";
        do {
            String laptopId = scanner.nextLine();
            if (Pattern.matches(laptopRegex, laptopId)) {
                //kiểm tra tính trùng lặp
                if (Main.laptops.stream().anyMatch(lap -> lap.getLaptopId().equals(laptopId))) {
                    System.err.println("Mã laptop đã bị trùng, vui lòng nhập lại:");
                } else {
                    return laptopId;
                }
            } else {
                System.err.println("Mã laptop không đúng định dạng, vui lòng nhập lại:");
            }
        } while (true);
    }

    public String inputLaptopName(Scanner scanner) {
        System.out.println("Mời nhập tên laptop:");
        do {
            String laptopName = scanner.nextLine();
            if (laptopName.trim().isEmpty()) {
                System.err.println("Tên laptop không được để trống, vui lòng nhập lại:");
            } else if (Main.laptops.stream().anyMatch(lap -> lap.getLaptopName().equals(laptopName))) {
                System.err.println("Tên laptop đã bị trùng, vui lòng nhập lại:");
            } else {
                return laptopName.trim();
            }
        } while (true);
    }
    public String inputDescription(Scanner scanner){
        System.out.println("Mời nhập mô tả của laptop:");
        do {
            String description = scanner.nextLine();
            if (description.trim().isEmpty()){
                System.err.println("Mô tả của laptop không được để trống, vui lòng nhập lại:");
            }else {
                return description.trim();
            }
        }while (true);
    }
    public String inputCustomerAddress(Scanner scanner){
        System.out.println("Mời nhập địa chỉ:");
        do {
            String customerAddress = scanner.nextLine();
            if (customerAddress.trim().isEmpty()){
                System.err.println("Địa chỉ không được để trống, vui lòng nhập lại:");
            }else {
                return customerAddress.trim();
            }
        }while (true);
    }
    public int inputRam (Scanner scanner){
        System.out.println("Mời nhập bộ nhớ:");
        do {
            try {
                int ram = Integer.parseInt(scanner.nextLine());
                if (ram>0){
                    return ram;
                }else {
                    System.err.println("Số bộ nhớ phải lớn hơn 0, vui lòng nhập lại:");
                }
            }catch (Exception ex){
                System.err.println("Bộ nhớ phải nhập số nguyên, vui lòng nhập lại");
            }
        }while (true);
    }
    public double inputWeight (Scanner scanner){
        System.out.println("Mời nhập cân nặng:");
        do {
            try {
                double weight = Double.parseDouble(scanner.nextLine());
                if (weight>0){
                    return weight;
                }else {
                    System.err.println("Số cân nặng phải lớn hơn 0, vui lòng nhập lại:");
                }
            }catch (Exception ex){
                System.err.println("số cân nặng không đúng định dạng, vui lòng nhập lại");
            }
        }while (true);
    }
    public double inputPrice(Scanner scanner){
        System.out.println("Mời nhập giá laptop:");
        do {
            double price = Double.parseDouble(scanner.nextLine());
            if (price > 0) {
                return price;
            }else {
                System.err.println("Giá laptop phải lớn hơn 0, vui lòng nhập lại:");
            }
        }while (true);
    }
    public int inputTypeId (Scanner scanner){
        System.out.println("Chọn Mã loại laptop:");
        for (int i = 0; i < Main.laptopTypes.size(); i++) {
            System.out.printf("%d. %s\n",(i+1),Main.laptopTypes.get(i).getTypeName());
        }
        System.out.println("Lựa chon của bạn:");
        int choice = Integer.parseInt(scanner.nextLine());
        return Main.laptopTypes.get(choice-1).getTypeId();
    }
    public boolean inputIsDelete(Scanner scanner){
        System.out.println("Mời nhập trạng thái:");
        do {
            String isDelete = scanner.nextLine();
            if (isDelete.equals("true")||isDelete.equals("false")){
                return Boolean.parseBoolean(isDelete);
            }else {
                System.err.println("trạng thái chỉ nhận giá trị true hoặc false, mời nhập lại:");
            }
        }while (true);
    }
    public void outputData(Scanner scanner){
        System.out.printf("Mã laptop: %s - Tên laptop: %s - Mô tả: %s - Địa chỉ: %s - Bộ nhớ: %d\n",
                this.laptopId, this.laptopName,this.description,this.customerAddress,this.ram);
        System.out.printf("Cân nặng máy: %d.2f - Giá tiền: %d - Mã loại laptop: %d - Trạng thái: %s\n",
                this.weight,this.laptopPrice,this.typeId,this.isDelete?"Xoá":"Chưa xoa");
    }
}
