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
CREATE USER DoiTac FOR LOGIN DoiTac
GO
--Khách hàng
CREATE USER KhachHang FOR LOGIN KhachHang
GO
--Tài xế
CREATE USER TaiXe FOR LOGIN TaiXe
GO
--Nhân viên
CREATE USER NhanVien FOR LOGIN NhanVien
GO
--Quản trị
CREATE USER QuanTri FOR LOGIN QuanTri
GO

--Bước 3: tạo role
--Đối tác
EXEC sp_addrole 'DOITAC_ROLE'
GO
--Khách hàng
EXEC sp_addrole 'KHACHHANG_ROLE'
GO
--Tài xế
EXEC sp_addrole 'TAIXE_ROLE'
GO
--Nhân viên
EXEC sp_addrole 'NHANVIEN_ROLE'
GO
--Quản trị
EXEC sp_addrole 'QUANTRI_ROLE'
GO

--Bước 4: Gán người dùng vào role. Lúc này role chưa có gán quyền
--Đối tác
ALTER ROLE DOITAC_ROLE
ADD member DoiTac
GO
--Khách hàng
ALTER ROLE KHACHHANG_ROLE
ADD member KhachHang
GO
--Tài xế
ALTER ROLE TAIXE_ROLE
ADD member TaiXe
GO
--Nhân viên
ALTER ROLE NHANVIEN_ROLE
ADD member NhanVien
GO
--Quản trị
ALTER ROLE QUANTRI_ROLE ADD member QuanTri
GO
ALTER ROLE db_accessadmin ADD member QuanTri
GO


--Bước 5: Cấp quyền cho Role 
--Đối tác
--Thêm/Xóa/Sửa thông tin sản phẩm và chi nhánh có cung cấp sản phẩm này.
GRANT SELECT,INSERT,UPDATE,DELETE ON SANPHAM TO DOITAC_ROLE 
GRANT SELECT,INSERT,UPDATE,DELETE ON CUNGCAP TO DOITAC_ROLE
GRANT SELECT,INSERT,UPDATE,DELETE ON CHINHANH TO DOITAC_ROLE 
--Xem thông tin hợp đồng
GRANT SELECT ON HOPDONG TO DOITAC_ROLE
--Xem thông tin đơn hàng
GRANT SELECT ON DONDH TO DOITAC_ROLE 
GRANT SELECT ON CHITIETDDH TO DOITAC_ROLE
--Cập nhật tình trạng của đơn hàng
GRANT UPDATE ON DONDH(TINHTRANG) TO DOITAC_ROLE 

GO

--Khách hàng
--Xem danh sách đối tác
GRANT SELECT ON DOITAC TO KHACHHANG_ROLE
--Hiển thị danh sách sản phẩm của đối tác
GRANT SELECT ON CUNGCAP TO KHACHHANG_ROLE 
GRANT SELECT ON SANPHAM TO KHACHHANG_ROLE
--Cập nhật thông tin đơn đặt hàng và 
--theo dõi quá trình vận chuyển đơn hàng
GRANT SELECT ON  CHITIETDDH TO KHACHHANG_ROLE 
GRANT SELECT ON DONDH TO KHACHHANG_ROLE 

GO

--Tài xế
--Xem thông tin đơn đặt hàng
GRANT SELECT ON DONDH TO TAIXE_ROLE
--Cập nhật tình trạng đơn hàng 
GRANT UPDATE ON DONDH(TINHTRANG) TO TAIXE_ROLE

GO

--Nhân viên
--Xem thông tin hợp đồng của đối tác
GRANT SELECT ON HOPDONG TO NHANVIEN_ROLE 
--Cập nhật thời gian gia hạn hợp đồng và phí hoa hồng
GRANT UPDATE ON HOPDONG(THGIANHIEULUC, PHIHOAHONG, KICHHOAT) 
             TO NHANVIEN_ROLE 

GO

--Quản trị
--Thêm/Xóa/Sửa tài khoản các người dùng
GRANT SELECT,INSERT,UPDATE,DELETE ON NGUOIDUNG 
                                  TO QUANTRI_ROLE