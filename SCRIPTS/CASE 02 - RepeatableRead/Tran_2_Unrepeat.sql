-- UNREPEAT CASE01
SELECT * FROM HOPDONG WHERE MST = (SELECT MST FROM HOPDONG WHERE MAHD = '00B')

EXEC USP_GIAHANHD '00B', '2021/07/07', '2022/07/08'

SELECT * FROM HOPDONG WHERE MST = (SELECT MST FROM HOPDONG WHERE MAHD = '00B')


-- UNREPEAT CASE02
SELECT * FROM SANPHAM

EXEC USP_DOITENSP '00C3', N'bơ', N'thanh long'

SELECT * FROM SANPHAM


-- UNREPEAT CASE03
SELECT * FROM NGUOIDUNG

EXEC USP_DOIMATKHAU 'TaiXe', '3575994263'

SELECT * FROM NGUOIDUNG