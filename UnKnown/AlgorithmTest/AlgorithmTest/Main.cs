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
            //SRT srt = new SRT( test.data );
            //RoundRobin rrb = new RoundRobin( test.data, 1 );
            //Priority pr = new Priority( test.data );
            //HRN hrn = new HRN( test.data );
            SJF sjf = new SJF( test.data );

            test.data = sjf.working();

            test.check();

            Console.WriteLine( "평균대기시간 : " + sjf.avg_wait() + "ms" );
            Console.WriteLine( "평균반환시간 : " + sjf.avg_return() + "ms" );
            Console.WriteLine();
        }
    }
}
