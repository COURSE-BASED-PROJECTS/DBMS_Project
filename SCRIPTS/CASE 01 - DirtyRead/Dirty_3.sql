-- [KHÁCH HÀNG] Thay đổi địa chỉ giao hàng
CREATE
-- ALTER
PROC USP_CAPNHATDCGH
    @MADDH CHAR(20),
    @DIACHIMOI NVARCHAR(200)
AS
BEGIN TRAN
    UPDATE DONDH
    SET DIACHIGIAOHANG = @DIACHIMOI
    WHERE   MADDH = @MADDH

    WAITFOR DELAY '00:00:10'
ROLLBACK TRAN
GO

-- [TÀI XẾ] truy vấn địa chỉ giao hàng
------------VẤN TIN ĐỊA CHỈ GIAO HÀNG---------------
CREATE
--ALTER
PROC USP_VANTINDCGH
    @MADDH CHAR(20)
AS
BEGIN TRAN
    SET TRAN ISOLATION LEVEL READ UNCOMMITTED --READ WITH NO S LOCK

    BEGIN TRY
        SELECT * FROM DONDH WHERE MADDH = @MADDH
    END TRY
    BEGIN CATCH
        DECLARE @ERRORMSG NVARCHAR(1000)
        SET @ERRORMSG = N'LỖI : ' + ERROR_MESSAGE()
        RAISERROR (@ERRORMSG, 16,1)
        ROLLBACK TRAN
        RETURN
    END CATCH
    PRINT N'VẤN TIN ĐỊA CHỈ GIAO HÀNG THÀNH CÔNG'
COMMIT TRAN