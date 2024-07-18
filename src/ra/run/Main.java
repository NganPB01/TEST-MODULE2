package ra.run;

import ra.entity.Laptop;
import ra.entity.LaptopType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Laptop> laptops = new ArrayList<>();
    public static List<LaptopType> laptopTypes = new ArrayList<LaptopType>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("************************LAPTOP MANAGEMENT************************");
            System.out.println("1. Quản lý loại laptop");
            System.out.println("2. Quản lý laptop");
            System.out.println("3. Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = inputChoiceMenu(scanner.nextLine());
            switch (choice) {
                case 1:
                    Main.displayLaptopTypeMenu(scanner);
                    break;
                case 2:
                    Main.displayLaptopMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Mời nhập số trong khoảng từ 1-3:");
            }
        } while (true);
    }

    public static void displayLaptopTypeMenu(Scanner scanner) {
        boolean isExist = true;
        do {
            System.out.println("********LAPTOP TYPE MENU********");
            System.out.println("1. Hiển thị danh sách các loại laptop");
            System.out.println("2. Thêm mới loại laptop");
            System.out.println("3. Cập nhật thông tin loại laptop");
            System.out.println("4. Xoá loại laptop");
            System.out.println("5. Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = inputChoiceMenu(scanner.nextLine());
            switch (choice) {
                case 1:
                    Main.displayLaptopType(scanner);
                    break;
                case 2:
                    Main.addNewLaptopType(scanner);
                    break;
                case 3:
                    Main.updateLaptopType(scanner);
                    break;
                case 4:
                    Main.deleteLaptopType(scanner);
                    break;
                case 5:
                    isExist = false;
                    break;
                default:
                    System.err.println("Mời nhập trong khoảng từ 1-5:");
            }
        } while (isExist);
    }

    public static void displayLaptopType(Scanner scanner) {
        for (LaptopType laptopType : laptopTypes) {
            if (!laptopType.isDelete()) {
                laptopType.outputData(scanner);
            }
        }
    }

    public static void addNewLaptopType(Scanner scanner) {
        LaptopType typeNew = new LaptopType();
        typeNew.inputData(scanner);
        laptopTypes.add(typeNew);
        System.out.println("Đã thêm mới loại Laptop thành công");
    }

    public static void updateLaptopType(Scanner scanner) {
        System.out.println("Mời nhập mã thể loại laptop cần cập nhật:");
        int updateId = Integer.parseInt(scanner.nextLine());
        int indexId = getIndexById(updateId);
        if (indexId >= 0) {
            boolean isExist = true;
            do {
                System.out.println("1. Cập nhật tên thể loại");
                System.out.println("2. Cập nhật mô tả thể loại");
                System.out.println("3. Thoát");
                System.out.println("Lựa chọn của bạn:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Điền thông tin cập nhật tên loại laptop:");
                        laptopTypes.get(indexId).setTypeName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Điền thông tin cập nhật mô tả loại laptop:");
                        laptopTypes.get(indexId).setDescription(scanner.nextLine());
                        break;
                    case 3:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Mời nhập lại trong khoảng từ 1-3:");
                }
            } while (isExist);
        } else {
            System.err.println("Mã laptop không tồn tại");
        }
    }

    public static void deleteLaptopType(Scanner scanner) {
        System.out.println("Mời nhập mã loại laptop muốn xoá:");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int indexDeleteId = getIndexById(deleteId);
        if (indexDeleteId >= 0) {
            laptopTypes.remove(indexDeleteId);
            System.out.println("Đã xoá thành công");
        } else {
            System.err.println("Mã loại laptop cần xoá không tồn tại");
        }
    }

    public static int getIndexById(int id) {
        for (int i = 0; i < Main.laptopTypes.size(); i++) {
            if (laptopTypes.get(i).getTypeId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static void displayLaptopMenu(Scanner scanner) {
        boolean isExist = true;
        do {
            System.out.println("********LAPTOP MENU********");
            System.out.println("1. Danh sách laptop");
            System.out.println("2. Thêm mới laptop");
            System.out.println("3. Cập nhật thông tin laptop");
            System.out.println("4. Xoá laptop");
            System.out.println("5. Thống kê số lượng laptop theo từng loại");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = inputChoiceMenu(scanner.nextLine());
            switch (choice) {
                case 1:
                    Main.displayLaptop(scanner);
                    break;
                case 2:
                    Main.addNewLaptop(scanner);
                    break;
                case 3:
                    Main.updateLaptop(scanner);
                    break;
                case 4:
                    Main.deleteLaptop(scanner);
                    break;
                case 5:
                    Main.statisticLaptop();
                    break;
                case 6:
                    isExist = false;
                    break;
                default:
                    System.err.println("Mời nhập trong khoảng từ 1-6:");
            }
        } while (isExist);
    }

    public static void displayLaptop(Scanner scanner) {
        for (Laptop laptop : laptops) {
            if (!laptop.isDelete()) {
                laptop.outputData(scanner);
            }
        }
    }

    public static void addNewLaptop(Scanner scanner) {
        Laptop laptopNew = new Laptop();
        laptopNew.inputData(scanner);
        laptops.add(laptopNew);
        System.out.println("Đã thêm mới Laptop thành công");
    }

    public static void updateLaptop(Scanner scanner) {
        System.out.println("Mời nhập mã laptop cần cập nhật:");
        int updateId = Integer.parseInt(scanner.nextLine());
        int indexId = getIndexByLaptopId(updateId);
        if (indexId >= 0) {
            boolean isExist = true;
            do {
                System.out.println("1. Cập nhật tên laptop");
                System.out.println("2. Cập nhật mô tả laptop");
                System.out.println("3. Cập nhật địa chỉ");
                System.out.println("4. Cập nhật bộ nhớ laptop");
                System.out.println("5. Cập nhật cân nặng laptop");
                System.out.println("6. Thoát");
                System.out.println("Lựa chọn của bạn:");
                int choice = inputChoiceMenu(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Điền thông tin cập nhật tên laptop:");
                        laptops.get(indexId).setLaptopName((scanner.nextLine()));
                        break;
                    case 2:
                        System.out.println("Điền thông tin cập nhật mô tả laptop:");
                        laptops.get(indexId).setDescription(scanner.nextLine());
                        break;
                    case 3:
                        System.out.println("Điền thông tin cập nhật địa chỉ laptop:");
                        laptops.get(indexId).setCustomerAddress(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Điền thông tin cập nhật bộ nhớ laptop:");
                        laptops.get(indexId).setRam(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Điền thông tin cập nhật cân nặng laptop:");
                        laptops.get(indexId).setWeight(Double.parseDouble(scanner.nextLine()));
                        break;
                    case 6:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Mời nhập lại trong khoảng từ 1-6:");
                }
            } while (isExist);
        } else {
            System.err.println("Mã laptop không tồn tại");
        }
    }

    public static void deleteLaptop(Scanner scanner) {
        System.out.println("Mời nhập mã laptop muốn xoá:");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int indexDeleteId = getIndexByLaptopId(deleteId);
        if (indexDeleteId >= 0) {
            laptops.remove(indexDeleteId);
            System.out.println("Đã xoá thành công");
        } else {
            System.err.println("Mã laptop cần xoá không tồn tại");
        }
    }

    public static void statisticLaptop() {
        for (LaptopType type : laptopTypes) {
            System.out.printf("0%d - %s : %d laptop\n", type.getTypeId(), type.getTypeName(),
                    laptops.stream().filter(laptop -> laptop.getTypeId() == type.getTypeId()).count());
        }
    }

    public static int getIndexByLaptopId(int id) {
        for (int i = 0; i < Main.laptops.size(); i++) {
            if (laptops.get(i).getTypeId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static int inputChoiceMenu(String choiceStr) {
        do {
            try {
                int choice = Integer.parseInt(choiceStr);
                return choice;
            } catch (Exception ex) {
                System.err.println("Lỗi không xác định, mời nhập lại số nguyên:");
            }
        } while (true);
    }
}
