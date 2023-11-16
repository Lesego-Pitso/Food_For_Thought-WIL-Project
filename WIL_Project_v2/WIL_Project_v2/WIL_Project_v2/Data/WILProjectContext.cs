using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using WIL_Project_v2;

namespace WIL_Project_v2.Data
{
    public class WILProjectContext : DbContext
    {
        public WILProjectContext(DbContextOptions<WILProjectContext> options)
            : base(options) 
        { 
        }

        public DbSet<WIL_Project_v2.Models.Details> Details { get; set; } = default!;
        public DbSet<WIL_Project_v2.Models.SignIn>? SignIn { get; set; }
        public DbSet<WIL_Project_v2.Models.SignOut>? SignOut { get; set; }
    }
}
