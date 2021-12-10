CREATE DATABASE QLCH
GO 
USE QLCH
GO

CREATE TABLE DOITAC
(
	MST CHAR(20),
	NGUOIDAIDIEN NVARCHAR(50),
	TENDT NVARCHAR(50),
	SLCHINHANH INT,
	LOAIHANG NVARCHAR(50),
	DIACHI NVARCHAR(200),
	SDT CHAR(10),
	EMAIL CHAR(50),

	PRIMARY KEY(MST)
)
GO
CREATE TABLE HOPDONG
(
	MST CHAR(20),
	NGUOIDAIDIEN NVARCHAR(50),
	MAHD CHAR(20),
	THGIANBATDAU DATETIME,
	THGIANHIEULUC DATETIME,
	PHIHOAHONG MONEY,
	SOCHINHANHDK INT,
	KICHHOAT BIT -- 1 ĐÃ LẬP/ 0 CHƯA LẬP

	PRIMARY KEY(MST, MAHD)
)
GO
CREATE TABLE DANGKY
(
	MST CHAR(20),
	NGUOIDAIDIEN NVARCHAR(50),
	MAHD CHAR(20),
	MACHINHANH CHAR(20),
	DANGKY CHAR(10),
	
	PRIMARY KEY(MST, MAHD, MACHINHANH)
)
GO
CREATE TABLE CHINHANH
(
	MST CHAR(20),
	NGUOIDAIDIEN NVARCHAR(50),
	MACHINHANH CHAR(20),
	DIACHI NVARCHAR(200),

	PRIMARY KEY(MST, MACHINHANH)
)
GO
CREATE TABLE CUNGCAP
(
	MST CHAR(20),
	MACHINHANH CHAR(20),
	MASP CHAR(20),
	GIASP INT,

	PRIMARY KEY(MST, MACHINHANH, MASP)
)
GO
CREATE TABLE SANPHAM
(
	MASP CHAR(20),
	TENSP NVARCHAR(200),

	PRIMARY KEY(MASP)
)
GO
CREATE TABLE CHITIETDDH
(
	MADDH CHAR(20),
	MASP CHAR(20),
	SLSP INT,
	DONGIA MONEY,

	PRIMARY KEY(MADDH, MASP)
)
GO
CREATE TABLE DONDH
(
	MADDH CHAR(20),
	MAKH CHAR(20),
	MATAIXE CHAR(20),
	DIACHIGIAOHANG NVARCHAR(200),
	HINHTHUCTT NVARCHAR(20),
	PHIVANCHUYEN MONEY,
	PHISP MONEY,
	TINHTRANG NVARCHAR(20),
	TONGTIEN MONEY,

	PRIMARY KEY(MADDH)
)
GO
CREATE TABLE KHACHHANG
(
	MAKH CHAR(20),
	HOTEN NVARCHAR(50),
	SDT CHAR(10),
	DIACHI NVARCHAR(200),
	EMAIL CHAR(50),

	PRIMARY KEY(MAKH)
)
GO
CREATE TABLE TAIXE 
(
	MATAIXE CHAR(20),
	HOTEN NVARCHAR(50),
	CMND CHAR(20),
	SDT CHAR(10),
	DIACHI NVARCHAR(200),
	BIENSOXE CHAR(5),
	KHUVUCHD NVARCHAR(200),
	EMAIL CHAR(50),
	TKNGANHANG VARCHAR(30),

	PRIMARY KEY(MATAIXE)
)
GO

GO
CREATE TABLE NGUOIDUNG
(
	TAIKHOAN VARCHAR(200),
	MATKHAU VARCHAR(200),
	PHANHE NVARCHAR(20),
	TINHTRANG BIT --1 KICHHOAT/ 0 KHOA

	PRIMARY KEY(TAIKHOAN)
)
GO

ALTER TABLE HOPDONG ADD 
	CONSTRAINT FK_HOPDONG_DOITAC FOREIGN KEY (MST) REFERENCES DOITAC(MST)
GO

ALTER TABLE DANGKY ADD 
	CONSTRAINT FK_DANGKY_HOPDONG FOREIGN KEY (MST,MAHD) REFERENCES HOPDONG(MST,MAHD),
	CONSTRAINT FK_DANGKY_CHINHANH FOREIGN KEY (MST,MACHINHANH) REFERENCES CHINHANH(MST,MACHINHANH)
GO

ALTER TABLE CHINHANH ADD 
	CONSTRAINT FK_CHINHANH_DOITAC FOREIGN KEY (MST) REFERENCES DOITAC(MST)

GO

ALTER TABLE CUNGCAP ADD 
	CONSTRAINT FK_CUNGCAP_CHINHANH FOREIGN KEY (MST,MACHINHANH) REFERENCES CHINHANH(MST,MACHINHANH),
	CONSTRAINT FK_CUNGCAP_SANPHAM FOREIGN KEY (MASP) REFERENCES SANPHAM(MASP)
GO

ALTER TABLE CHITIETDDH ADD 
	CONSTRAINT FK_CHITIETDDH_SANPHAM FOREIGN KEY (MASP) REFERENCES SANPHAM(MASP),
	CONSTRAINT FK_CHITIETDDH_DONDH FOREIGN KEY (MADDH) REFERENCES DONDH(MADDH)
GO

ALTER TABLE DONDH ADD 
	CONSTRAINT FK_DONDH_KHACHHANG FOREIGN KEY (MAKH) REFERENCES KHACHHANG(MAKH),
	CONSTRAINT FK_DONDH_TAIXE FOREIGN KEY (MATAIXE) REFERENCES TAIXE(MATAIXE)
GO

----------------------
GO
INSERT INTO DOITAC(MST,NGUOIDAIDIEN,TENDT,SLCHINHANH,LOAIHANG,DIACHI,SDT,EMAIL)
	VALUES  ('0312614186', N'Nguyễn Văn An', N'Đại Toàn Phát', '3', N'Thực Phẩm',N'123 Nguyễn Văn Cừ, Quận 5, TPHCM','0909123123','dtphat@gmail.com'),
			('0191818716', N'Nguyễn Đức Quân', N'Đại Tiến', '4', N'Thực Phẩm',N'234 Nguyễn Văn Linh, Quận Thủ Đức, TPHCM','0909123111','dtien@gmail.com'),
			('0137692698', N'Trần Văn Đức', N'Phát Tài', '3', N'Đồ uống',N'456/1 Trương Định, Quận 3, TPHCM','0909456456','ptai@gmail.com'),
			('0342107164', N'Phạm Đăng Phú', N'Phát Đạt', '2', N'Trái Cây',N'34 Quang Trung, Quận Gò Vấp, TPHCM','0909456555','pdat@gmail.com'),
			('0809669861', N'Hoàng Gia Bảo', N'Thành Vũ', '2', N'Thực phẩm',N'64 Lê Trọng Tấn, Quận Tân Phú, TPHCM','0982216872','hgbao@gmail.com'),
			('0745271814', N'Lê Hoàng Bảo Nam', N'Phúc An', '1', N'Sữa',N'194 Lê Văn Quới, Quận Bình Tân, TPHCM','0908815690','lhbnam@gmail.com'),
			('0497492975', N'Cao Hoàng Ánh Duyên', N'Ninh Hoa', '3', N'Bánh kẹo',N'304 Ung Văn Khiêm, Quận Bình Thạnh, TPHCM','0975444201','chaduyen@gmail.com'),
			('0528984542', N'Trần Thanh Như', N'Định Vân', '3', N'Đồ uống',N'715 Lý Thường Kiệt, Quận Tân Bình, TPHCM','0974140412','ttnhu@gmail.com'),
			('0213489216', N'Nguyễn Minh Bảo', N'Gia Bảo', '1', N'Đồ uống',N'528 Trường Chinh, Quận 12, TPHCM','0918774546','nmbao@gmail.com')
GO
INSERT INTO SANPHAM(MASP,TENSP)
	VALUES  ('00A1', N'rồng đỏ'),
			('00B1', N'đu đủ'),
			('00C1', N'cơm sườn'),
			('00C2', N'xá xị'),
			('00B2', N'măng cụt'),
			('00C3', N'bơ'),
			('00C4', N'cháo lươn'),
			('00A2', N'7up'),
			('00A3', N'bia 333'),
			('00B3', N'bia heineken'),
			('00A4', N'snacks'),
			('00A5', N'trà hoa quả'),
			('00D1', N'sữa tươi'),
			('00B4', N'soda chanh'),
			('00D2', N'bánh sữa bò')
GO
INSERT INTO KHACHHANG(MAKH,HOTEN,SDT,DIACHI,EMAIL)
	VALUES  ('201A',N'Trương Mạnh','0912001222',N'123 Vân Đồn, Q.4, TPHCM','tmanh@gmail.com'),
			('102B',N'Vòng Khải My','0912712723',N'495A Cách Mạng Tháng Tám, Quận 10, TPHCM','vkmy@gmail.com'),
			('203A',N'Lê Tấn Đăng Tâm','0913222222',N'số 64 Trương Định, Phường 7, Quận 3, TPHCM','ltdtam@gmail.com'),
			('407C',N'Trương Quốc An','0909000222',N'1 Đ. Trường Chinh, Tân Phú, TPHCM','tqan@gmail.com'),
			('608D',N'Trần Thị Anh Thư','0911111222',N'28 Trương Công Định, Phường 14, Tân Bình, TPHCM','ttathu@gmail.com'),
			('16A',N'Trần Lê Hồng Nhi','0798181991',N'31 Nguyễn Thị Thập, Bình Thuận, Quận 7, TPHCM','tlhnhi@gmail.com'),
			('05D',N'Phạm Lê Thùy Dung','0703169797',N'45 Hoàng Hoa Thám, Phường 6, Bình Thạnh, TPHCM','pltdung@gmail.com'),
			('43A',N'Đặng Khánh Mai','0783450303',N'429 Hai Bà Trưng, Tân Định, Quận 1, TPHCM','dkmai@gmail.com'),
			('171A',N'Tăng Lợi Phát','0769696982',N'67/45D Hoàng Hoa Thám, Phường 6, Bình Thạnh, TPHCM','tlphat@gmail.com'),
			('571B',N'Nguyễn Ngọc Anh Khoa','0783339090',N'12 Đ. Quốc Hương, Thảo Điền, Quận 2, TPHCM','nnakhoa@gmail.com')
GO
INSERT INTO TAIXE(MATAIXE,HOTEN,CMND,SDT,DIACHI,BIENSOXE,KHUVUCHD,EMAIL,TKNGANHANG)
	VALUES  ('A12',N'Nguyễn Tấn Vĩnh','3575994263','0969814449',N'33 Trương Công Định, Phường 14, Tân Bình, TPHCM','17441','Quận 5','ntvinh@gmail.com','905989045479'),
			('B14',N'Lê Hải','3137078839','0394253123',N'55 Bà Huyện Thanh Quan, Phường 6, Quận 3, TPHCM','79230','Quận 10','lhai@gmail.com','567343215259'),
			('A34',N'Nguyễn Ngọc Quỳnh','3761127023',N'0376111704',N'22 TER Điện Biên Phủ, Phường 25, Bình Thạnh, TPHCM','88927','Quận 8','nnquynh@gmail.com','487383057409'),
			('C05',N'Tân Hoàng','3901625323','0375812786',N'152 Nguyễn Thái Bình, Phường 12, Tân Bình, TPHCM','86769','Quận Tân Phú','thoang@gmail.com','626110959269'),
			('C07',N'Dương Đăng','7934361957','0866901801',N'96 Cao Thắng, Phường 4, Quận 3, TPHCM','22016','Quận 3','ddang@gmail.com','376579554157'),
			('A98',N'Bùi Thị Lan','9696921667','0369634889',N'14 Ký Con, Phường Nguyễn Thái Bình, Quận 1, TPHCM','44930','Quận 7','btlan@gmail.com','228845407842'),
			('D09',N'Trần Thái','4449708971','0328373723',N'85 Đường Hùng Vương, Phường 4, Quận 5, TPHCM','46860','Quận 2','tthai@gmail.com','700150859136')
GO
INSERT INTO HOPDONG(MST,NGUOIDAIDIEN,MAHD,THGIANBATDAU,THGIANHIEULUC, KICHHOAT)
	VALUES  ('0312614186',N'Nguyễn Văn An','00A','2020/04/12','2021/09/12',1),
			('0191818716',N'Nguyễn Đức Quân','00B','2020/05/07','2021/07/07',1),
			('0312614186',N'Nguyễn Văn An','01A','2020/10/09','2021/12/09',1),
			('0312614186',N'Nguyễn Văn An','11B','2022/01/01','2023/11/01',0),
			('0137692698',N'Trần Văn Đức','22C','2021/01/05','2022/01/05',1),
			('0342107164',N'Phạm Đăng Phú','11C','2020/09/09','2021/12/09',1),
			('0342107164',N'Phạm Đăng Phú','07B','2021/12/09','2022/12/01',0),
			('0809669861', N'Hoàng Gia Bảo','12A','2019/12/12','2022/12/12',1),
			('0809669861', N'Hoàng Gia Bảo','13A','2021/11/16','2023/11/16',0),
			('0745271814', N'Lê Hoàng Bảo Nam','00D','2021/01/11','2022/01/11',1),
			('0497492975', N'Cao Hoàng Ánh Duyên','06C','2021/02/01','2021/11/11',1),
			('0497492975', N'Cao Hoàng Ánh Duyên','07C','2022/11/11','2023/11/11',0),
			('0528984542', N'Trần Thanh Như','09B','2020/05/03','2021/09/11',1),
			('0528984542', N'Trần Thanh Như','10B','2021/10/12','2022/10/12',1),
			('0213489216', N'Nguyễn Minh Bảo','23C','2020/04/11','2022/04/11',1)
GO
INSERT INTO CHINHANH(MST,NGUOIDAIDIEN,MACHINHANH,DIACHI)
	VALUES  ('0312614186',N'Nguyễn Văn An','A00',N'222 Xô Viết Nghệ Tĩnh, Phường 21, Bình Thạnh, Thành phố Hồ Chí Minh'),
			('0191818716',N'Nguyễn Đức Quân','B00',N'Tạ Quang Bửu, Phường 5, Quận 8, Thành phố Hồ Chí Minh'),
			('0312614186',N'Nguyễn Văn An','A01',N'351/5A An D. Vương, Phường 10, Quận 6, Thành phố Hồ Chí Minh'),
			('0312614186',N'Nguyễn Văn An','A02',N'191 Nguyễn Thị Thập, Bình Thuận, Quận 7, Thành phố Hồ Chí Minh'),
			('0137692698',N'Trần Văn Đức','C00',N'43 Ngô Thời Nhiệm, Phường 6, Quận 3, Thành phố Hồ Chí Minh'),
			('0137692698',N'Trần Văn Đức','C01',N'40/15 Đ. Lâm Văn Bền, Tân Thuận Tây, Quận 7, Thành phố Hồ Chí Minh'),
			('0137692698',N'Trần Văn Đức','C02',N'10, Nguyễn Huệ, Phường Bến Nghé, Quận 1, Thành Phố Hồ Chí Minh'),
			('0342107164',N'Phạm Đăng Phú','D00',N'Đoàn Văn Bơ, Phường 14, Quận 4, Thành phố Hồ Chí Minh'),
			('0342107164',N'Phạm Đăng Phú','D01',N'64 Chu Văn An, Phường 1, Quận 6, Thành phố Hồ Chí Minh'),
			('0191818716',N'Nguyễn Đức Quân','B01',N'783 Trần Xuân Soạn, Tân Hưng, Quận 7, Thành phố Hồ Chí Minh'),
			('0191818716',N'Nguyễn Đức Quân','B02',N'32/1 Đường Tôn Đản, Phường 10, Quận 4, Thành phố Hồ Chí Minh'),
			('0191818716',N'Nguyễn Đức Quân','B03',N'59 Đường số 1E, Khu dân cư Trung Sơn, Bình Chánh, Thành phố Hồ Chí Minh'),
			('0809669861', N'Hoàng Gia Bảo','D02', N'672 Lê Văn Khương, Phường Thới An, Quận 12, Thành phố Hồ Chí Minh'),
			('0809669861', N'Hoàng Gia Bảo','D03', N'72 Nghĩa Phát, Phường 7, Quận Tân Bình, Thành phố Hồ Chí Minh'),
			('0745271814', N'Lê Hoàng Bảo Nam', 'E00', N'80 Thân Nhân Trung, Phường 13, Quận Tân Bình, Thành phố Hồ Chí Minh'),
			('0497492975', N'Cao Hoàng Ánh Duyên', 'E01', N'460 Phạm Văn Chiêu, Phường 13, Quận Gò Vấp, Thành phố Hồ Chí Minh'),
			('0497492975', N'Cao Hoàng Ánh Duyên', 'E02', N'380 Nguyễn Thị Thập, Phường Tân Phong, Quận 7, Thành phố Hồ Chí Minh'),
			('0497492975', N'Cao Hoàng Ánh Duyên', 'E03', N'30 Nguyễn Hoàng, Phường An Phú, Quận 2, Thành phố Hồ Chí Minh'),
			('0528984542', N'Trần Thanh Như', 'C03', N'920 Hà Huy Giáp, Phường Thạnh Lộc, Quận 12, Thành phố Hồ Chí Minh'),
			('0528984542', N'Trần Thanh Như', 'C04', N'1007 Quang Trung, Phường 12, Quận Gò Vấp, Thành phố Hồ Chí Minh'),
			('0528984542', N'Trần Thanh Như', 'C05', N'187 Trường Chinh, Phường 12, Quận Tân Bình, Thành phố Hồ Chí Minh'),
			('0213489216', N'Nguyễn Minh Bảo', 'B04', N'635 Lã Xuân Oai, Phường Trường Thạnh, Quận 9, Thành phố Hồ Chí Minh')
GO
INSERT INTO DANGKY(MST,NGUOIDAIDIEN,MAHD,MACHINHANH)
	VALUES  ('0312614186',N'Nguyễn Văn An','00A','A00'),
			('0191818716',N'Nguyễn Đức Quân','00B','B00'),
			('0312614186',N'Nguyễn Văn An','01A','A01'),
			('0312614186',N'Nguyễn Văn An','11B','A02'),
			('0137692698',N'Trần Văn Đức','22C','C00'),
			('0342107164',N'Phạm Đăng Phú','11C','D00'),
			('0342107164',N'Phạm Đăng Phú','07B','D01'),
			('0809669861', N'Hoàng Gia Bảo','12A','D02'),
			('0809669861', N'Hoàng Gia Bảo','13A','D03'),
			('0745271814', N'Lê Hoàng Bảo Nam','00D','E00'),
			('0497492975', N'Cao Hoàng Ánh Duyên','06C','E01'),
			('0497492975', N'Cao Hoàng Ánh Duyên','07C','E02'),
			('0528984542', N'Trần Thanh Như','09B','C03'),
			('0528984542', N'Trần Thanh Như','10B','C05'),
			('0213489216', N'Nguyễn Minh Bảo','23C','B04')

GO
INSERT INTO CUNGCAP(MST,MACHINHANH,MASP, GIASP)
	VALUES  ('0312614186','A00','00C1', '25000'),
			('0191818716','B00','00C4', '25000'),
			('0312614186','A01','00C4', '23000'),
			('0312614186','A02','00C1', '35000'),
			('0137692698','C00','00A1', '7000'),
			('0342107164','D00','00B2', '95000'),
			('0342107164','D01','00C3', '32000'),
			('0342107164','D00', '00B1', '18000'),
			('0137692698','C00','00B3', '17500'),
			('0137692698','C00','00A3', '11000'),
			('0137692698','C00','00A2', '10600'),
			('0809669861','D02','00C1', '30000'),
			('0809669861','D03','00C4', '20000'),
			('0745271814','E00','00D1', '8000'),
			('0497492975','E01','00A4', '9000'),
			('0497492975','E02','00D2', '23750'),
			('0528984542','C03','00B4', '5000'),
			('0528984542','C05','00B3', '16500'),
			('0213489216','B04','00A5', '37000')
GO
INSERT INTO DONDH(MADDH,MAKH,MATAIXE,DIACHIGIAOHANG,HINHTHUCTT,PHIVANCHUYEN,TINHTRANG)
	VALUES  ('111','201A','A12',N'30 Nguyễn Thị Thập, Bình Thuận, Quận 7, Thành phố Hồ Chí Minh',N'tiền mặt','30000',N'Đang vận chuyển'),
			('112','43A','C05',N'32/1 Đường Tôn Đản, Phường 10, Quận 4, Thành phố Hồ Chí Minh',N'tiền mặt','32500',N'Đang đóng gói'),
			('113','43A','A12',N'108 Dương Quang Đông, Phường 5, Quận 8, Thành phố Hồ Chí Minh',N'chuyển khoản','20000',N'Đang vận chuyển'),
			('114','571B','D09',N'346 Bến Vân Đồn, Phường 1, Quận 4, Thành phố Hồ Chí Minh',N'momo','10000',N'Đang đóng gói'),
			('211','571B','D09',N'61 Âu Dương Lân, Phường 3, Quận 8, Thành phố Hồ Chí Minh',N'chuyển khoản','31000',N'Đã chuyển tới kho'),
			('212','171A','A98',N'63 Vũ Tông Phan, An Phú, Quận 2, Thành phố Hồ Chí Minh',N'momo','5000',N'Đã giao hàng'),
			('213','05D','C07',N'30 Nguyễn Thị Thập, Bình Thuận, Quận 7, Thành phố Hồ Chí Minh',N'chuyển khoản','3000',N'Hủy đơn hàng'),
			('214','608D','A12',N'43 Đường Số 9, khu dân cư, Bình Chánh, Thành phố Hồ Chí Minh',N'momo','9800',N'Đã giao hàng'),
			('215','201A','A34',N'Nguyễn Thị Định, Phường Thạnh Mỹ Lợi, Quận 2, Thành phố Hồ Chí Minh',N'viettel pay','15200',N'Đã chuyển tới kho'),
			('216','203A','A34',N'52 Đ. Thành Thái, Phường 12, Quận 10, Thành phố Hồ Chí Minh',N'viettel pay','33200',N'Đã giao hàng'),
			('311','203A','A34',N'10 Đường Mai Chí Thọ, An Lợi Đông, Thành Phố Thủ Đức, Thành phố Hồ Chí Minh',N'tiền mặt','45000',N'Đang đóng gói')
GO
INSERT INTO CHITIETDDH(MADDH,MASP,SLSP)
	VALUES  ('111','00B1',20),
			('216','00C1',34),
			('214','00A3',50),
			('212','00C1',100),
			('112','00B3',70),
			('211','00A3',15),
			('311','00B2',1),
			('113','00A2',5)
GO
INSERT INTO NGUOIDUNG(TAIKHOAN, MATKHAU, PHANHE, TINHTRANG)
	VALUES  ('DoiTac','DoiTac','DoiTac',1),
			('KhachHang','KhachHang','KhachHang',1),
			('TaiXe','TaiXe','TaiXe',1),
			('NhanVien','NhanVien','NhanVien',1),
			('QuanTri','QuanTri','QuanTri',1)


GO
UPDATE HOPDONG 
	SET SOCHINHANHDK = '3', PHIHOAHONG = '57104000'
	WHERE MST = '0312614186' AND MAHD = '00A'
UPDATE HOPDONG	
	SET SOCHINHANHDK = '3', PHIHOAHONG = '56184000'
	WHERE MST = '0312614186' AND MAHD = '01A'

UPDATE HOPDONG 
	SET SOCHINHANHDK = '1', PHIHOAHONG = '52961000'
	WHERE MST = '0191818716'AND MAHD = '00B'

UPDATE HOPDONG 
	SET SOCHINHANHDK = '2', PHIHOAHONG = '52986000'
	WHERE MST = '0137692698'AND MAHD = '22C'

UPDATE HOPDONG 
	SET SOCHINHANHDK = '2', PHIHOAHONG = '59708000'
	WHERE MST = '0342107164' AND MAHD = '11C'

UPDATE HOPDONG 
	SET SOCHINHANHDK = '1', PHIHOAHONG = '48711000'
	WHERE MST = '0809669861' AND MAHD = '12A'

UPDATE HOPDONG 
	SET SOCHINHANHDK = '1', PHIHOAHONG = '63067000'
	WHERE MST = '0745271814' AND MAHD = '00D'

UPDATE HOPDONG 
	SET SOCHINHANHDK = '2', PHIHOAHONG = '58143000'
	WHERE MST = '0497492975' AND MAHD = '06C'

UPDATE HOPDONG 
	SET SOCHINHANHDK = '2', PHIHOAHONG = '55827000'
	WHERE MST = '0528984542' AND MAHD = '09B'
UPDATE HOPDONG 
	SET SOCHINHANHDK = '2', PHIHOAHONG = '56134000'
	WHERE MST = '0528984542' AND MAHD = '10B'

UPDATE HOPDONG 
	SET SOCHINHANHDK = '1', PHIHOAHONG = '58210000'
	WHERE MST = '0213489216' AND MAHD = '23C'

GO
UPDATE CHITIETDDH
	SET DONGIA = '18000' WHERE MADDH = '111' AND MASP = '00B1'
UPDATE CHITIETDDH
	SET DONGIA = '30000' WHERE MADDH = '216' AND MASP = '00C1'
UPDATE CHITIETDDH
	SET DONGIA = '11000' WHERE MADDH = '214' AND MASP = '00A3'
UPDATE CHITIETDDH
	SET DONGIA = '25000' WHERE MADDH = '212' AND MASP = '00C1'
UPDATE CHITIETDDH
	SET DONGIA = '17500' WHERE MADDH = '112' AND MASP = '00B3'
UPDATE CHITIETDDH
	SET DONGIA = '11000' WHERE MADDH = '211' AND MASP = '00A3'
UPDATE CHITIETDDH
	SET DONGIA = '95000' WHERE MADDH = '311' AND MASP = '00B2'
UPDATE CHITIETDDH
	SET DONGIA = '10600' WHERE MADDH = '113' AND MASP = '00A2'

GO
UPDATE DONDH 
	SET PHISP = '360000', TONGTIEN = '390000' WHERE MADDH = '111' 
UPDATE DONDH
	SET PHISP = '1020000' , TONGTIEN = '1053200' WHERE MADDH = '216'
UPDATE DONDH
	SET PHISP = '550000' , TONGTIEN = '559800' WHERE MADDH = '214' 
UPDATE DONDH
	SET PHISP = '2500000' , TONGTIEN = '2505000' WHERE MADDH = '212'
UPDATE DONDH
	SET PHISP = '1225000' , TONGTIEN = '1257500' WHERE MADDH = '112'
UPDATE DONDH
	SET PHISP = '165000' , TONGTIEN = '196000' WHERE MADDH = '211' 
UPDATE DONDH
	SET PHISP = '95000' , TONGTIEN = '140000' WHERE MADDH = '311'
UPDATE DONDH
	SET PHISP = '53000' , TONGTIEN = '73000' WHERE MADDH = '113'