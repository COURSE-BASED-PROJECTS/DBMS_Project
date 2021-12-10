--CẬP NHẬT NGƯỜI ĐẠI DIỆN
CREATE 
--ALTER
PROC USP_CAPNHATNGUOIDAIDIEN
	@MST CHAR(20),
    @DAIDIENMOI NVARCHAR(50)
AS
BEGIN TRAN
	DECLARE @DAIDIEN NVARCHAR(50) = (SELECT NGUOIDAIDIEN
							        FROM DOITAC 
							        WHERE MST = @MST)
	PRINT N'NGƯỜI ĐẠI DIỆN HIỆN TẠI: ' + @DAIDIEN
	WAITFOR DELAY '0:0:05'

	BEGIN TRY
		UPDATE DOITAC
		SET NGUOIDAIDIEN = @DAIDIENMOI
		WHERE MST = @MST

        UPDATE HOPDONG
		SET NGUOIDAIDIEN = @DAIDIENMOI
		WHERE MST = @MST

        UPDATE DANGKY
		SET NGUOIDAIDIEN = @DAIDIENMOI
		WHERE MST = @MST

        UPDATE CHINHANH
		SET NGUOIDAIDIEN = @DAIDIENMOI
		WHERE MST = @MST

	END TRY
	BEGIN CATCH 
		DECLARE @ErrorMsg VARCHAR(2000)
		SELECT @ErrorMsg = N'Lỗi: ' + ERROR_MESSAGE()
		RAISERROR(@ErrorMsg, 16,1)
		ROLLBACK TRAN
		RETURN
	END CATCH
	PRINT N'NGƯỜI ĐẠI DIỆN : ' + @DAIDIENMOI
	PRINT N'CẬP NHẬT NGƯỜI ĐẠI DIỆN THÀNH CÔNG'
COMMIT TRAN