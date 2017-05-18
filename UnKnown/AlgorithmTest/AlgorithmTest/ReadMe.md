This project is writing now.
============================

---

### 1. 프로세스에 대한 자료구조는 ProcessData.cs 에 정의되어 있습니다.

```cs
class ProcessData
{
    public string no { get; set; }
    public string pid { get; set; }
    public string priority { get; set; }
    public string arrived_time { get; set; }
    public string service_time { get; set; }

    public ProcessData()
    {
        no = pid = priority = arrived_time = service_time = "";
    }

    public ProcessData( string[] data )
    {
        no           = data[ 0 ];
        pid          = data[ 1 ];
        priority     = data[ 2 ];
        arrived_time = data[ 3 ];
        service_time = data[ 4 ];
    }

}

class Cal_Temp
{
    public string no { get; set; }
    public string pid { get; set; }
    public string priority { get; set; }
    public string arrived_time { get; set; }
    public string service_time { get; set; }
    public double respone_value { get; set; }

    public Cal_Temp( string[] data, double _response )
    {
        no           = data[ 0 ];
        pid          = data[ 1 ];
        priority     = data[ 2 ];
        arrived_time = data[ 3 ];
        service_time = data[ 4 ];
        respone_value = _response;
    }

    public override string ToString()
    {
        return string.Format( no + "\t" + pid + "\t" + priority + "\t" + arrived_time + "\t" + service_time + "\t" + respone_value );
    }
}
```

---

1.	Common.cs 에는 List<ProcessData> 에 대한 정렬 방법이 정의되어 있습니다. --------------------------------------------------------------------------

---

```cs
class Common
{
    public const int START_PID = 1000;
    public const int JOB = 1;

    #region begin follow section
    /* pid 순 정렬, 차트용 */
    private static int Follow_Default( ProcessData A, ProcessData B )
    {
        if ( Convert.ToInt32( A.pid ) < Convert.ToInt32( B.pid ) )
            return -1;
        return 1;
    }

    /* 도착 시간 정렬 */
    private static int Follow_Initialize( ProcessData A, ProcessData B )
    {
        if ( Convert.ToInt32( A.arrived_time ) < Convert.ToInt32( B.arrived_time ) )
            return -1;
        return 1;
    }

    /* 서비스 시간 정렬 */
    private static int Follow_SRT( ProcessData A, ProcessData B )
    {
        if ( Convert.ToInt32( A.service_time ) < Convert.ToInt32( B.service_time ) )
            return -1;
        if ( ( Convert.ToInt32( A.service_time ) == Convert.ToInt32( B.service_time ) ) &&
            ( Convert.ToInt32( A.pid ) < Convert.ToInt32( B.pid ) ) )
            return -1;
        return 1;
    }

    /* 우선순위 정렬 */
    private static int Follow_Priority( ProcessData A, ProcessData B )
    {
        if ( Convert.ToInt32( A.priority ) >= Convert.ToInt32( B.priority ) )
            return -1;
        return 1;
    }

    /* 응답시간 순위 정렬 */
    private static int Follow_HRN( Cal_Temp A, Cal_Temp B )
    {
        if ( Convert.ToInt32( A.respone_value ) >= Convert.ToInt32( B.respone_value ) )
            return -1;
        return 1;
    }
    #endregion

    #region begin sort section
    public static List<ProcessData> Sort_Default( List<ProcessData> data )
    {
        data.Sort( Follow_Default );
        return data;
    }

    public static List<ProcessData> Sort_Initialize( List<ProcessData> data )
    {
        data.Sort( Follow_Initialize );
        return data;
    }

    public static List<ProcessData> Sort_SRT( List<ProcessData> data )
    {
        data.Sort( Follow_SRT );
        return data;
    }

    public static List<ProcessData> Sort_Priority( List<ProcessData> data )
    {
        data.Sort( Follow_Priority );
        return data;
    }

    public static List<Cal_Temp> Sort_HRN( List<Cal_Temp> data )
    {
        data.Sort( Follow_HRN );
        return data;
    }
    #endregion
}
```

---

1.	프로그램의 시작은 Main.cs 이며 테스트 데이터는 TestCase.cs 에 정의되어 있습니다. -----------------------------------------------------------------------------------
