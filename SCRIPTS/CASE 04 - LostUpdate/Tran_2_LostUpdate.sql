--LOST UPDATE CASE 01
SELECT * FROM HOPDONG WHERE MST = '0809669861'
EXEC USP_PHIHH_HANGNAM '0809669861', '12A', '6289000'

SELECT * FROM HOPDONG WHERE MST = '0809669861'


--LOST UPDATE CASE 02
SELECT * FROM DOITAC WHERE MST = '0528984542'
EXEC USP_CAPNHATNGUOIDAIDIEN '0528984542', N'Đoàn Minh Hoàng'

SELECT * FROM DOITAC WHERE MST = '0528984542'
SELECT * FROM HOPDONG WHERE MST = '0528984542'
SELECT * FROM DANGKY WHERE MST = '0528984542'
SELECT * FROM CHINHANH WHERE MST = '0528984542'