--DIRTY READ: CASE 01

SELECT * FROM CUNGCAP

EXEC USP_CAPNHATGIASP '001','A02','00C1', 40000

SELECT * FROM CUNGCAP


----DIRTY READ: CASE 02
SELECT * FROM DONDH

EXEC USP_CAPNHATDDH '111', N'Đã giao hàng'

SELECT * FROM DONDH