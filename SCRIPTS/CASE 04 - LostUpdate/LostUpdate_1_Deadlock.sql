--CẬP NHẬT PHÍ HOA HỒNG ĐỊNH KỲ 1 THÁNG
--CREATE 
ALTER
PROC USP_PHIHH_HANGTHANG
	@MST CHAR(20),
	@MAHD CHAR(20),
	@SOTIEN MONEY
AS
BEGIN TRAN
    SET TRAN ISOLATION LEVEL REPEATABLE READ --get S, keep until commit
	DECLARE @PHIHH MONEY = (SELECT PHIHOAHONG
							FROM HOPDONG 
							WHERE MST = @MST AND MAHD = @MAHD)
	PRINT N'PHÍ HOA HỒNG HIỆN TẠI: ' + CAST(@PHIHH AS CHAR(20))
	WAITFOR DELAY '0:0:05'

	BEGIN TRY
		UPDATE HOPDONG
		SET PHIHOAHONG = @SOTIEN + PHIHOAHONG
		WHERE MST = @MST AND MAHD = @MAHD

	END TRY
	BEGIN CATCH 
		DECLARE @ErrorMsg VARCHAR(2000)
		SELECT @ErrorMsg = N'Lỗi: ' + ERROR_MESSAGE()
		RAISERROR(@ErrorMsg, 16,1)
		ROLLBACK TRAN
		RETURN
	END CATCH
	PRINT N'PHÍ HOA HỒNG MỚI : ' + CAST((@SOTIEN + @PHIHH) AS CHAR(20))
	PRINT N'CẬP NHẬT PHÍ HÀNG THÁNG THÀNH CÔNG'
COMMIT TRAN
GO

--CẬP NHẬT PHÍ HOA HỒNG ĐỊNH KỲ 1 NĂM
--CREATE 
ALTER
PROC USP_PHIHH_HANGNAM
	@MST CHAR(20),
	@MAHD CHAR(20),
	@SOTIEN MONEY
AS
BEGIN TRAN
    SET TRAN ISOLATION LEVEL REPEATABLE READ --get S, keep until commit
	DECLARE @PHIHH MONEY = (SELECT PHIHOAHONG
							FROM HOPDONG 
							WHERE MST = @MST AND MAHD = @MAHD)

	PRINT N'PHÍ HOA HỒNG HIỆN TẠI: ' + CAST(@PHIHH AS CHAR(20))

	BEGIN TRY
		UPDATE HOPDONG
		SET PHIHOAHONG = @SOTIEN + PHIHOAHONG
		WHERE MST = @MST AND MAHD = @MAHD
	END TRY
	BEGIN CATCH 
		DECLARE @ErrorMsg VARCHAR(2000)
		SELECT @ErrorMsg = N'Lỗi: ' + ERROR_MESSAGE()
		RAISERROR(@ErrorMsg, 16,1)
		ROLLBACK TRAN
		RETURN
	END CATCH
	PRINT N'PHÍ HOA HỒNG MỚI : ' + CAST((@SOTIEN + @PHIHH) AS CHAR(20))
	PRINT N'CẬP NHẬT PHÍ HÀNG NĂM THÀNH CÔNG'
COMMIT TRAN