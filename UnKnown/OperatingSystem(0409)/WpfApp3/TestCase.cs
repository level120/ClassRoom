using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Altest
{
    class TestCase
    {
        public List<ProcessData> data;

        public TestCase()
        {
            data = new List<ProcessData>();

            data.Add(new ProcessData(new string[] { "1", "1000", "0", "0", "3" }));
            data.Add(new ProcessData(new string[] { "2", "1001", "0", "2", "6" }));
            data.Add(new ProcessData(new string[] { "3", "1002", "0", "4", "4" }));
            data.Add(new ProcessData(new string[] { "4", "1003", "0", "6", "5" }));
            data.Add(new ProcessData(new string[] { "5", "1004", "0", "8", "2" }));
        }

        public void check()
        {
            for (int i = 0; i < data.Count; i++)
            {
                Console.WriteLine(data[i].no + "\t" + data[i].pid + "\t" + data[i].priority + "\t" + data[i].arrived_time + "\t" + data[i].service_time);
            }
            Console.WriteLine();
        }
    }
}
