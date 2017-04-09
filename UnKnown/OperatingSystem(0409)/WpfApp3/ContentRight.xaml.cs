using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace WpfApp3
{
    /// <summary>
    /// ContentRight.xaml에 대한 상호 작용 논리
    /// </summary>
    public partial class ContentRight : UserControl
    {
        public ContentRight()
        {
            InitializeComponent();

            UserInit();
        }

        private void UserInit()
        {
            /* DataGrid 한글 막기 */
            InputMethod.SetIsInputMethodEnabled(this.ProcessTable, false);
        }

        /* DataGrid Nermeric Only */
        private void ProcessTable_PreviewTextInput(object sender, TextCompositionEventArgs e)
        {
            foreach (char c in e.Text)
            {
                if (!char.IsDigit(c))
                {
                    e.Handled = true;
                    break;
                }
            }
        }
    }
}
