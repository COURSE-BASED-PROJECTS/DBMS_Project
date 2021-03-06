-- Cập nhật tình trạng đơn đặt hàng
CREATE
-- ALTER
PROC USP_CAPNHATDDH
    @MADDH CHAR(20),
    @TINHTRANG NVARCHAR(20)
AS
BEGIN TRAN
    UPDATE DONDH
    SET TINHTRANG = @TINHTRANG
    WHERE MADDH = @MADDH

    WAITFOR DELAY '00:00:10'
ROLLBACK TRAN
GO

------------VẤN TIN SẢN PHẨM----------------
CREATE
--ALTER
PROC USP_VANTINDDH
    @MADDH CHAR(20)
AS
BEGIN TRAN
    SET TRAN ISOLATION LEVEL READ UNCOMMITTED --READ WITH NO S LOCK
    DECLARE @TRANGTHAI NVARCHAR(50) = ''
    BEGIN TRY
    --    SET @TRANGTHAI = (SELECT TINHTRANG
      --                      FROM DONDH
        --                    WHERE MADDH = @MADDH)
       -- PRINT N'TRẠNG THÁI HIỆN TẠI CỦA ĐƠN HÀNG ' + @MADDH + ' : ' + @TRANGTHAI
	   SELECT * FROM DONDH WHERE MADDH = @MADDH

    END TRY
    BEGIN CATCH
        DECLARE @ERRORMSG NVARCHAR(1000)
        SET @ERRORMSG = N'LỖI : ' + ERROR_MESSAGE()
        RAISERROR (@ERRORMSG, 16,1)
        ROLLBACK TRAN
        RETURN
    END CATCH
    PRINT N'VẤN TIN ĐƠN ĐẶT HÀNG THÀNH CÔNG'
COMMIT TRAN