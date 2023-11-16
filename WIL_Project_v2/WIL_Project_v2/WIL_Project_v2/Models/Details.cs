using Microsoft.Data.SqlClient;
using MySql.Data.MySqlClient;
using MySqlConnector;
using System.ComponentModel.DataAnnotations;

namespace WIL_Project_v2.Models
{
    public class Details
    {
        private static int nextId = 1;
        private static List<Details> userDatabase = new List<Details>();
        [Key]
        public int Id { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Username { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public Details()
        {
            Id = nextId;
            nextId++;
        }

        public void ConnectingString()
        {
            //All connection strings made are saved on the appsettings.json page
        }
    }
}
