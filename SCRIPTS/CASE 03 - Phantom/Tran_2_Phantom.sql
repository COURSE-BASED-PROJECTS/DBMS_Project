--PHANTOM CASE 01--
EXEC USP_THEMSANPHAM '00E1', N'Xúc xích' 

SELECT * FROM SANPHAM 


--PHANTOM CASE 02--
EXEC USP_THEMDOITAC '0138600287',N'Lưu Viễn Văn',N'Tây Trung Châu','2',N'Sữa',N'137 Nguyễn Xiển, Phường Long Thạnh Mỹ, Quận 9, Thành phố Hồ Chí Minh','0909090991','lvvan@gmail.com' 

SELECT * FROM DOITAC


--PHANTOM CASE 03--
EXEC USP_THEMCHINHANH '0312614186', 'A03', N'192 Tây Thạnh, Phường Tây Thạnh, Quận Tân Phú, Thành phố Hồ Chí Minh'

SELECT * FROM CHINHANH WHERE MST = '0312614186'