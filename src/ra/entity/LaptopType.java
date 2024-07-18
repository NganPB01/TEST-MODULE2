package ra.entity;

import ra.run.Main;

import java.util.Comparator;
import java.util.Scanner;

public class LaptopType {
    private int typeId;
    private String typeName;
    private String description;
    private String bookId;
    private boolean isDelete;

    public LaptopType() {
    }

    public LaptopType(int typeId, String typeName, String description, String bookId, boolean isDelete) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.description = description;
        this.bookId = bookId;
        this.isDelete = isDelete;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public void inputData(Scanner scanner) {
        this.typeId = inputTypeId(scanner);
        this.typeName = inputTypeName(scanner);
        this.description = inputDescription(scanner);
        this.isDelete = inputIsDelete(scanner);
    }

    public int inputTypeId(Scanner scanner) {
        //sắp xếp id tăng dần
        if (Main.laptopTypes.size() == 0) {
            return 1;
        }
        //tìm max id trong laptopType
        int idMax = Main.laptopTypes.stream().max(Comparator.comparing(type -> type.getTypeId())).get().getTypeId();
        return idMax + 1;
    }

    public String inputTypeName(Scanner scanner) {
        System.out.println("Mời nhập vào tên loại laptop:");
        do {
            String typeName = scanner.nextLine();
            if (typeName.trim().isEmpty()) {
                System.err.println("Tên loại laptop không được để trống, vui lòng nhập lại:");
            } else if (Main.laptopTypes.stream().anyMatch(type -> type.getTypeName().equals(typeName))) {
                System.err.println("Tên loại laptop đã tồn tại, vui lòng nhập lại");
            } else {
                return typeName.trim();
            }
        } while (true);
    }
    public String inputDescription(Scanner scanner) {
        System.out.println("Mời nhập mô tả:");
        do {
            String description = scanner.nextLine();
            if (description.trim().isEmpty()) {
                System.err.println("Mô tả không được để trống, vui lòng nhập lại:");
            }else {
                return description.trim();
            }
        }while (true);
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
        System.out.printf("Mã loại laptop: %d - Tên loại laptop: %s - Mô tả: %s - Trạng thái: %s\n",
                this.typeId,this.typeName,this.description,this.isDelete?"Xoá":"Chưa xoá");
    }
}
