USE QLCH
GO

--Bước 1: tạo các login
--Đối tác
EXEC sp_addLogin 'DoiTac','DoiTac','QLCH'
GO
--Khách hàng
EXEC sp_addlogin 'KhachHang','KhachHang','QLCH'
GO
--Tài xế
EXEC sp_addlogin 'TaiXe','TaiXe','QLCH'
GO
--Nhân viên
EXEC sp_addlogin 'NhanVien','NhanVien','QLCH'
GO
--Quản trị
EXEC sp_addlogin 'QuanTri','QuanTri','QLCH'
GO

--Bước 2: Tạo các user tương ứng
--Đối tác
CREATE USER DOITACA FOR LOGIN DoiTac
GO
--Khách hàng
CREATE USER KHACHHANGA FOR LOGIN KhachHang
GO
--Tài xế
CREATE USER TAIXEA FOR LOGIN TaiXe
GO
--Nhân viên
CREATE USER NHANVIENA FOR LOGIN NhanVien
GO
--Quản trị
CREATE USER QUANTRIA FOR LOGIN QuanTri
GO

--Bước 3: tạo role
--Đối tác
EXEC sp_addrole 'DoiTac'
GO
--Khách hàng
EXEC sp_addrole 'KhachHang'
GO
--Tài xế
EXEC sp_addrole 'TaiXe'
GO
--Nhân viên
EXEC sp_addrole 'NhanVien'
GO
--Quản trị
EXEC sp_addrole 'QuanTri'
GO

--Bước 4: Gán người dùng vào role. Lúc này role chưa có gán quyền
--Đối tác
ALTER ROLE DoiTac
ADD member DOITACA
GO
--Khách hàng
ALTER ROLE KhachHang
ADD member KHACHHANGA
GO
--Tài xế
ALTER ROLE TaiXe
ADD member TAIXEA
GO
--Nhân viên
ALTER ROLE NhanVien
ADD member NHANVIENA
GO
--Quản trị
ALTER ROLE QuanTri ADD member QUANTRIA
GO
ALTER ROLE db_accessadmin ADD member QUANTRIA
GO


--Bước 5: Cấp quyền cho Role 
--Đối tác
--Thêm/Xóa/Sửa thông tin sản phẩm và chi nhánh có cung cấp sản phẩm này.
GRANT SELECT,INSERT,UPDATE,DELETE ON SANPHAM TO DoiTac 
GRANT SELECT,INSERT,UPDATE,DELETE ON CUNGCAP TO DoiTac
GRANT SELECT,INSERT,UPDATE,DELETE ON CHINHANH TO DoiTac 
--Xem thông tin hợp đồng
GRANT SELECT ON HOPDONG TO DoiTac
--Xem thông tin đơn hàng
GRANT SELECT ON DONDH TO DoiTac 
GRANT SELECT ON CHITIETDDH TO DoiTac
--Cập nhật tình trạng của đơn hàng
GRANT UPDATE ON DONDH(TINHTRANG) TO DoiTac 

GO

--Khách hàng
--Xem danh sách đối tác
GRANT SELECT ON DOITAC TO KhachHang
--Hiển thị danh sách sản phẩm của đối tác
GRANT SELECT ON CUNGCAP TO KhachHang 
GRANT SELECT ON SANPHAM TO KhachHang
--Cập nhật thông tin đơn đặt hàng và 
--theo dõi quá trình vận chuyển đơn hàng
GRANT SELECT ON  CHITIETDDH TO KhachHang 
GRANT SELECT ON DONDH TO KhachHang 

GO

--Tài xế
--Xem thông tin đơn đặt hàng
GRANT SELECT ON DONDH TO TaiXe
--Cập nhật tình trạng đơn hàng 
GRANT UPDATE ON DONDH(TINHTRANG) TO TaiXe

GO

--Nhân viên
--Xem thông tin hợp đồng của đối tác
GRANT SELECT ON HOPDONG TO NhanVien 
--Cập nhật thời gian gia hạn hợp đồng và phí hoa hồng
GRANT UPDATE ON HOPDONG(THGIANHIEULUC, PHIHOAHONG, KICHHOAT) 
             TO NhanVien 

GO

--Quản trị
--Thêm/Xóa/Sửa tài khoản các người dùng
GRANT SELECT,INSERT,UPDATE,DELETE ON NGUOIDUNG 
                                  TO QuanTri