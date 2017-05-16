using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
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

        public ProcessData(string[] data)
        {
            no           = data[0];
            pid          = data[1];
            priority     = data[2];
            arrived_time = data[3];
            service_time = data[4];
        }

    }
}
