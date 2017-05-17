using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    class Program
    {
        static void Main( string[] args )
        {
            TestCase test = new TestCase();

            test.check();

            //FCFS fcfs = new FCFS(test.data);
            SRT srt = new SRT( test.data );

            test.data = srt.working();

            test.check();

            Console.WriteLine( "평균대기시간 : " + srt.avg_wait() + "ms" );
            Console.WriteLine( "평균반환시간 : " + srt.avg_return() + "ms" );
            Console.WriteLine();
        }
    }
}
